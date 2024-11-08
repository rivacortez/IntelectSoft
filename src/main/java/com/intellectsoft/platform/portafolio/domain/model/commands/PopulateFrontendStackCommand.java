package com.intellectsoft.platform.portafolio.domain.model.commands;

import com.intellectsoft.platform.portafolio.domain.model.entities.FrontendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.FrontendStackName;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.FrontendStackRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PopulateFrontendStackCommand {

    private final FrontendStackRepository frontendStackRepository;

    public PopulateFrontendStackCommand(FrontendStackRepository frontendStackRepository) {
        this.frontendStackRepository = frontendStackRepository;
    }

    @PostConstruct
    public void handle() {
        List<FrontendStackName> frontendStackNames = Arrays.asList(FrontendStackName.values());

        for (FrontendStackName stackName : frontendStackNames) {
            if (frontendStackRepository.findByName(stackName).isEmpty()) {
                FrontendStack frontendStack = new FrontendStack(stackName);
                frontendStackRepository.save(frontendStack);
            }
        }
    }
}