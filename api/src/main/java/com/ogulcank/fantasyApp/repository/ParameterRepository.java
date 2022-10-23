package com.ogulcank.fantasyApp.repository;

import com.ogulcank.fantasyApp.models.Parameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParameterRepository extends JpaRepository<Parameter,String> {
}
