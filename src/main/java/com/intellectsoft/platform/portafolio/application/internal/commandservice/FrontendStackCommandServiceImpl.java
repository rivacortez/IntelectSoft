package com.intellectsoft.platform.portafolio.application.internal.commandservice;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateFrontendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.entities.FrontendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.FrontendStackName;
import com.intellectsoft.platform.portafolio.domain.services.FrontendStackCommandService;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.FrontendStackRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 * FrontendStackCommandServiceImpl
 * @summary
 * The FrontendStackCommandServiceImpl class is responsible for handling the frontend stack commands.
 * It implements the FrontendStackCommandService interface.
 * @see FrontendStackCommandService
 * @since 1.0.0
 */
@Service
public class FrontendStackCommandServiceImpl implements FrontendStackCommandService {

    private final FrontendStackRepository frontendStackRepository;

    /**
     * Constructs a new FrontendStackCommandServiceImpl with the specified repository.
     * @param frontendStackRepository the repository for frontend stacks
     */
    public FrontendStackCommandServiceImpl(FrontendStackRepository frontendStackRepository) {
        this.frontendStackRepository = frontendStackRepository;
    }

    /**
     * Handles the creation of a new frontend stack.
     * @param command the command containing the details of the frontend stack to be created
     * @return an Optional containing the created FrontendStack, or an empty Optional if creation failed
     * @throws IllegalArgumentException if the frontend stack ID is invalid or if a stack with the same name already exists
     */
    @Override
    public Optional<FrontendStack> handle(CreateFrontendStackCommand command) {
        if (command.id() == null || command.id() <= 0) {
            throw new IllegalArgumentException("Invalid Frontend Stack ID: " + command.id());
        }

        FrontendStackName frontendStackName = command.frontendStack().getName();

        if (frontendStackRepository.existsByName(frontendStackName)) {
            throw new IllegalArgumentException("Frontend Stack with name: " + frontendStackName + " already exists");
        }

        FrontendStack frontendStack = new FrontendStack(frontendStackName);
        try {
            frontendStackRepository.save(frontendStack);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving frontend stack: " + e.getMessage());
        }
        return Optional.of(frontendStack);
    }
}