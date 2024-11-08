package com.intellectsoft.platform.portafolio.application.internal.commandservice;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateBackendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.entities.BackendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.BackendStackName;
import com.intellectsoft.platform.portafolio.domain.services.BackendStackCommandService;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.BackendStackRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 * BackendStackCommandServiceImpl
 * @summary
 * The BackendStackCommandServiceImpl class is responsible for handling the backend stack commands.
 * It implements the BackendStackCommandService interface.
 * @see BackendStackCommandService
 * @since 1.0.0
 */
@Service
public class BackendStackCommandServiceImpl implements BackendStackCommandService {

    private final BackendStackRepository backendStackRepository;

    public BackendStackCommandServiceImpl(BackendStackRepository backendStackRepository) {
        this.backendStackRepository = backendStackRepository;
    }

    // @inheritdoc
    @Override
    public Optional<BackendStack> handle(CreateBackendStackCommand command) {
        if (command.id() == null || command.id() <= 0) {
            throw new IllegalArgumentException("Invalid Backend Stack ID: " + command.id());
        }

        BackendStackName backendStackName = command.backendStack().getName();

        if (backendStackRepository.existsByName(backendStackName)) {
            throw new IllegalArgumentException("Backend Stack with name: " + backendStackName + " already exists");
        }

        BackendStack backendStack = new BackendStack(backendStackName);
        try {
            backendStackRepository.save(backendStack);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving backend stack: " + e.getMessage());
        }
        return Optional.of(backendStack);
    }
}