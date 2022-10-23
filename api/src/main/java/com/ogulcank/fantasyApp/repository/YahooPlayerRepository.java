package com.ogulcank.fantasyApp.repository;

import com.ogulcank.fantasyApp.models.YahooPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface YahooPlayerRepository extends JpaRepository<YahooPlayer, String> {
    Optional<YahooPlayer> findByPlayerNameAndPlayerTeamAndPlayerPos(String playerName, String playerTeam, String playerPos);
}
