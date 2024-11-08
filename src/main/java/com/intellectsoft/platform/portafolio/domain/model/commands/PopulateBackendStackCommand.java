package com.intellectsoft.platform.portafolio.domain.model.commands;

import com.intellectsoft.platform.portafolio.domain.model.entities.BackendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.BackendStackName;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.BackendStackRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * PopulateBackendStackCommand
 * @summary
 * PopulateBackendStackCommand is a service class responsible for populating the backend stack repository with predefined backend stack names.
 * It ensures that each backend stack name is saved in the repository if it does not already exist.
 * @see BackendStackRepository
 * @since 1.0.0
 */
@Service
public class PopulateBackendStackCommand {

    private final BackendStackRepository backendStackRepository;

    /**
     * Constructs a new PopulateBackendStackCommand with the specified repository.
     * @param backendStackRepository - the repository for backend stacks
     */
    public PopulateBackendStackCommand(BackendStackRepository backendStackRepository) {
        this.backendStackRepository = backendStackRepository;
    }

    /**
     * Handles the population of backend stacks.
     * This method is called after the bean's properties have been set.
     * It iterates through all predefined backend stack names and saves them in the repository if they do not already exist.
     */
    @PostConstruct
    public void handle() {
        List<BackendStackName> backendStacksName = Arrays.asList(BackendStackName.values());

        for (BackendStackName stackName : backendStacksName) {
            if (backendStackRepository.findByName(stackName).isEmpty()) {
                BackendStack backendStack = new BackendStack(stackName);
                backendStackRepository.save(backendStack);
            }
        }
    }
}