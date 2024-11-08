package com.intellectsoft.platform.portafolio.domain.services;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateCloudPlatformStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.entities.CloudPlatform;

import java.util.Optional;

/**
 * CloudStackCommandService Interface
 * @summary
 * The CloudStackCommandService interface defines a contract for handling cloud platform stack commands.
 * It contains a method to handle the creation of a cloud platform stack.
 * @since 1.0.0
 */
public interface CloudStackCommandService {
    /**
     * Handles the creation of a cloud platform stack.
     * @param command - the command to create a cloud platform stack
     * @return an Optional containing the created CloudPlatform, or an empty Optional if the creation failed
     */
    Optional<CloudPlatform> handle(CreateCloudPlatformStackCommand command);
}