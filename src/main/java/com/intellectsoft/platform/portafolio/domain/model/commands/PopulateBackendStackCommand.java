package com.intellectsoft.platform.portafolio.domain.model.commands;

import com.intellectsoft.platform.portafolio.domain.model.entities.BackendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.BackendStackName;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.BackendStackRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PopulateBackendStackCommand{

    private final BackendStackRepository backendStackRepository;

    public PopulateBackendStackCommand(BackendStackRepository backendStackRepository) {
        this.backendStackRepository = backendStackRepository;
    }


    @PostConstruct
    public void handle() {
        List<BackendStackName> backendStacksName = Arrays.asList(BackendStackName.values());

        for(BackendStackName stackName : backendStacksName) {
            if(backendStackRepository.findByName(stackName).isEmpty()) {
                BackendStack backendStack = new BackendStack(stackName);
                backendStackRepository.save(backendStack);
            }
        }
    }
}
