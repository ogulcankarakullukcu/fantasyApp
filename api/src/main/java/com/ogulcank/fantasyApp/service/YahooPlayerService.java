package com.ogulcank.fantasyApp.service;

import com.ogulcank.fantasyApp.models.YahooPlayer;
import com.ogulcank.fantasyApp.repository.YahooPlayerRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class YahooPlayerService {

    private final YahooPlayerRepository yahooPlayerRepository;

    public YahooPlayerService(YahooPlayerRepository yahooPlayerRepository) {
        this.yahooPlayerRepository = yahooPlayerRepository;
    }

    protected YahooPlayer getYahooPlayer(String playerName, String playerTeam, String playerPos){
        Optional<YahooPlayer> yahooPlayer = yahooPlayerRepository.findByPlayerNameAndPlayerTeamAndPlayerPos(playerName,playerTeam,playerPos);

        if(!yahooPlayer.isPresent()){
            return yahooPlayerRepository.save(new YahooPlayer(playerName,playerTeam,playerPos));
        }

        return yahooPlayer.get();

    }
}
