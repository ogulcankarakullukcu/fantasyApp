package com.ogulcank.fantasyApp.repository;

import com.ogulcank.fantasyApp.models.EspnPlayer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EspnPlayerRepository extends JpaRepository<EspnPlayer,String> {
    Optional<List<EspnPlayer>> findByPlayerNameEndingWith(String surname);

    Optional<List<EspnPlayer>> findByPlayerNameStartingWith(String firstName);
}
