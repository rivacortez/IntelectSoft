package com.intellectsoft.platform.portafolio.domain.services;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateBackendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.entities.BackendStack;

import java.util.Optional;

/**
 * BackendStackCommandService Interface
 * @summary
 * The BackendStackCommandService interface defines a contract for handling backend stack commands.
 * It contains a method to handle the creation of a backend stack.
 * @since 1.0.0
 */
public interface BackendStackCommandService {
    /**
     * Handles the creation of a backend stack.
     * @param command - the command to create a backend stack
     * @return an Optional containing the created BackendStack, or an empty Optional if the creation failed
     */
    Optional<BackendStack> handle(CreateBackendStackCommand command);
}