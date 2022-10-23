package com.ogulcank.fantasyApp.service;

import com.ogulcank.fantasyApp.models.Parameter;
import com.ogulcank.fantasyApp.repository.ParameterRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ParameterService {

    private final ParameterRepository parameterRepository;

    public ParameterService(ParameterRepository parameterRepository) {
        this.parameterRepository = parameterRepository;
    }

    protected String findByParamName(String paramName) throws Exception {
        Optional<Parameter> param = Optional.ofNullable(parameterRepository.findById(paramName).orElseThrow(Exception::new));
        return param.get().getParamValue();
    }
}
