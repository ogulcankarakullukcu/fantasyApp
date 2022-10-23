package com.ogulcank.fantasyApp.repository;

import com.ogulcank.fantasyApp.models.EspnTeam;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EspnTeamRepository extends JpaRepository<EspnTeam,String> {
    Optional<EspnTeam> findByTeamNameAbbrev(String teamNameAbbrev);
}
