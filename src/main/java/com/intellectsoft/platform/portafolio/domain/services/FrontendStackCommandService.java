package com.intellectsoft.platform.portafolio.domain.services;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateFrontendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.entities.FrontendStack;

import java.util.Optional;

/**
 * FrontendStackCommandService Interface
 * @summary
 * The FrontendStackCommandService interface defines a contract for handling frontend stack commands.
 * It contains a method to handle the creation of a frontend stack.
 * @since 1.0.0
 */
public interface FrontendStackCommandService {
    /**
     * Handles the creation of a frontend stack.
     * @param command - the command to create a frontend stack
     * @return an Optional containing the created FrontendStack, or an empty Optional if the creation failed
     */
    Optional<FrontendStack> handle(CreateFrontendStackCommand command);
}