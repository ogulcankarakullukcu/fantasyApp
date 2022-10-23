package com.ogulcank.fantasyApp.service;

import com.ogulcank.fantasyApp.models.EspnPlayer;
import com.ogulcank.fantasyApp.models.Stat;
import com.ogulcank.fantasyApp.models.StatRequest;
import com.ogulcank.fantasyApp.models.YahooPlayer;
import com.ogulcank.fantasyApp.repository.StatRepository;
import org.springframework.stereotype.Service;

import java.util.Objects;

import static java.lang.Double.parseDouble;

@Service
public class StatService {

    private final StatRepository statRepository;
    private final YahooPlayerService yahooPlayerService;
    private final EspnPlayerService  espnPlayerService;
    private final ParameterService parameterService;

    public StatService(StatRepository statRepository, YahooPlayerService yahooPlayerService, EspnPlayerService espnPlayerService, ParameterService parameterService) {
        this.statRepository = statRepository;
        this.yahooPlayerService = yahooPlayerService;
        this.espnPlayerService = espnPlayerService;
        this.parameterService = parameterService;
    }

    public void addStat(StatRequest statRequest) throws Exception {
        YahooPlayer yahooPlayer = yahooPlayerService.getYahooPlayer(statRequest.getPlayerName(),
                                                                    statRequest.getPlayerTeam(),
                                                                    statRequest.getPlayerPos());


        EspnPlayer espnPlayer = Objects.isNull(yahooPlayer.getEspnPlayer()) ? espnPlayerService.findEspnPlayer(yahooPlayer)
                                : yahooPlayer.getEspnPlayer();
        yahooPlayer.setEspnPlayer(espnPlayer);

        Stat stat = new Stat();
        stat.setFieldGoalsMade(parseDouble(statRequest.getFieldGoalsMade()));
        stat.setFieldGoalsAttempted(parseDouble(statRequest.getFieldGoalsAttempted()));
        stat.setFreeThrowsMade(parseDouble(statRequest.getFreeThrowsMade()));
        stat.setFreeThrowsAttempted(parseDouble(statRequest.getFreeThrowsAttempted()));
        stat.setThreePointShotsMade(parseDouble(statRequest.getThreePointShotsMade()));
        stat.setPointsScored(parseDouble(statRequest.getPointsScored()));
        stat.setTotalRebounds(parseDouble(statRequest.getTotalRebounds()));
        stat.setAssists(parseDouble(statRequest.getAssists()));
        stat.setSteals(parseDouble(statRequest.getSteals()));
        stat.setBlockedShots(parseDouble(statRequest.getBlockedShots()));
        stat.setTurnovers(parseDouble(statRequest.getTurnovers()));
        stat.setMatchupNo(parameterService.findByParamName("MATCHUP_NO"));
        stat.setEspnPlayer(espnPlayer);

        statRepository.save(stat);
    }
}
