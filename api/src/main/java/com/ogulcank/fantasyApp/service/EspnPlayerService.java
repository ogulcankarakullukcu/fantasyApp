package com.ogulcank.fantasyApp.service;

import com.ogulcank.fantasyApp.models.EspnPlayer;
import com.ogulcank.fantasyApp.models.EspnPlayerRequest;
import com.ogulcank.fantasyApp.models.EspnTeam;
import com.ogulcank.fantasyApp.models.YahooPlayer;
import com.ogulcank.fantasyApp.repository.EspnPlayerRepository;
import com.ogulcank.fantasyApp.utils.NbaTeams;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class EspnPlayerService {

    private final EspnPlayerRepository espnPlayerRepository;
    private final EspnTeamService espnTeamService;
    private final ParameterService parameterService;

    public EspnPlayerService(EspnPlayerRepository espnPlayerRepository, EspnTeamService espnTeamService, ParameterService parameterService) {
        this.espnPlayerRepository = espnPlayerRepository;
        this.espnTeamService = espnTeamService;
        this.parameterService = parameterService;
    }

    public void saveEspnPlayer(EspnPlayerRequest espnPlayerRequest) {

        try {
            EspnTeam espnTeam = espnTeamService.findByTeamNameAbbrev(espnPlayerRequest.getTeamNameAbbrev());

            espnPlayerRepository.save(
                    new EspnPlayer(espnPlayerRequest.getPlayerName(),
                            espnPlayerRequest.getPlayerTeam(),
                            espnPlayerRequest.getPlayerPos(),
                            parameterService.findByParamName("MATCHUP_NO"),
                            espnTeam,
                            new ArrayList<>()));

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    protected EspnPlayer findEspnPlayer(YahooPlayer yahooPlayer) {

        String firstName = yahooPlayer.getPlayerName().split("[.]")[0].trim();
        Optional<List<EspnPlayer>> listByFirstName = espnPlayerRepository.findByPlayerNameStartingWith(firstName);

        String surname = yahooPlayer.getPlayerName().split("[.]")[1].trim();
        Optional<List<EspnPlayer>> listBySurname = espnPlayerRepository.findByPlayerNameEndingWith(surname);

        if (listBySurname.isPresent() && listByFirstName.isPresent()) {

            Set<EspnPlayer> playersSet = listBySurname.get().stream()
                    .distinct()
                    .filter(listByFirstName.get()::contains)
                    .collect(Collectors.toSet());

            if (!playersSet.isEmpty()) {
                playersSet = playersSet.stream()
                                       .filter(t ->
                                               t.getPlayerTeam()
                                               .equals(NbaTeams.valueOfYahooProTeamName(yahooPlayer.getPlayerTeam())))
                                       .collect(Collectors.toSet());
                if(!playersSet.isEmpty()){
                    return playersSet.stream().findFirst().get();
                }
            }
        }

        return null;
    }
}
