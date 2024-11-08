package com.intellectsoft.platform.portafolio.domain.model.commands;

import com.intellectsoft.platform.portafolio.domain.model.entities.FrontendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.FrontendStackName;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.FrontendStackRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * PopulateFrontendStackCommand
 * @summary
 * PopulateFrontendStackCommand is a service class responsible for populating the frontend stack repository with predefined frontend stack names.
 * It ensures that each frontend stack name is saved in the repository if it does not already exist.
 * @see FrontendStackRepository
 * @since 1.0.0
 */
@Service
public class PopulateFrontendStackCommand {

    private final FrontendStackRepository frontendStackRepository;

    /**
     * Constructs a new PopulateFrontendStackCommand with the specified repository.
     * @param frontendStackRepository - the repository for frontend stacks
     */
    public PopulateFrontendStackCommand(FrontendStackRepository frontendStackRepository) {
        this.frontendStackRepository = frontendStackRepository;
    }

    /**
     * Handles the population of frontend stacks.
     * This method is called after the bean's properties have been set.
     * It iterates through all predefined frontend stack names and saves them in the repository if they do not already exist.
     */
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