package com.ogulcank.fantasyApp.repository;

import com.ogulcank.fantasyApp.models.Stat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StatRepository extends JpaRepository<Stat, String> {
}
