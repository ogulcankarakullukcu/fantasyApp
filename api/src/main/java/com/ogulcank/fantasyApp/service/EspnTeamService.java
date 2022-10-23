package com.ogulcank.fantasyApp.service;

import com.ogulcank.fantasyApp.models.EspnTeam;
import com.ogulcank.fantasyApp.repository.EspnTeamRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EspnTeamService {

    private final EspnTeamRepository espnTeamRepository;

    public EspnTeamService(EspnTeamRepository espnTeamRepository) {
        this.espnTeamRepository = espnTeamRepository;
    }

    public EspnTeam findByTeamNameAbbrev(String teamNameAbbrev) throws Exception {
        Optional<EspnTeam> espnTeam = Optional.ofNullable(espnTeamRepository.findByTeamNameAbbrev(teamNameAbbrev).orElseThrow(Exception::new));

        return espnTeam.get();
    }

    public void saveEspnTeam(EspnTeam espnTeam){
        espnTeamRepository.save(espnTeam);
    }
}
