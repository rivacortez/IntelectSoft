package com.intellectsoft.platform.portafolio.domain.services;

import com.intellectsoft.platform.portafolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.portafolio.domain.model.commands.CreateWebApplicationCommand;
import org.springframework.stereotype.Service;

import java.util.Optional;

/**
 * WebApplicationCommandService Interface
 * @summary
 * The WebApplicationCommandService interface defines a contract for handling web application commands.
 * It contains a method to handle the creation of a web application.
 * @since 1.0.0
 */
@Service
public interface WebApplicationCommandService {
    /**
     * Handles the creation of a web application.
     * @param command - the command to create a web application
     * @return an Optional containing the created WebApplication, or an empty Optional if the creation failed
     */
    Optional<WebApplication> handle(CreateWebApplicationCommand command);
}