package com.intellectsoft.platform.portafolio.application.internal.commandservice;

import com.intellectsoft.platform.portafolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.portafolio.domain.model.commands.CreateWebApplicationCommand;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.ClientId;
import com.intellectsoft.platform.portafolio.domain.services.WebApplicationCommandService;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.WebApplicationRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;

/**
 * WebApplicationCommandServiceImpl
 * @summary
 * The WebApplicationCommandServiceImpl class is responsible for handling the web application commands.
 * It implements the WebApplicationCommandService interface.
 * @see WebApplicationCommandService
 * @since 1.0.0
 */
@Service
public class WebApplicationCommandServiceImpl implements WebApplicationCommandService {

    private final WebApplicationRepository webApplicationRepository;

    /**
     * Constructs a new WebApplicationCommandServiceImpl with the specified repository.
     * @param webApplicationRepository the repository for web applications
     */
    public WebApplicationCommandServiceImpl(WebApplicationRepository webApplicationRepository) {
        this.webApplicationRepository = webApplicationRepository;
    }

    /**
     * Handles the creation of a new web application.
     * @param command the command containing the details of the web application to be created
     * @return an Optional containing the created WebApplication, or an empty Optional if creation failed
     * @throws IllegalArgumentException if the client ID is invalid, if a web application with the same frontend or backend URL already exists, if the availability percentage is out of range, or if the launch date is invalid
     */
    @Override
    public Optional<WebApplication> handle(CreateWebApplicationCommand command) {
        if (command.clientId() == null || command.clientId().clientId() <= 0) {
            throw new IllegalArgumentException("Invalid Client ID: " + command.clientId());
        }

        if (webApplicationRepository.existsByFrontendUrlOrBackendUrl(command.frontendUrl(), command.backendUrl())) {
            throw new IllegalArgumentException("Web Application with the same frontendUrl or backendUrl already exists");
        }

        if (command.availabilityPercentage() < 85 || command.availabilityPercentage() > 99) {
            throw new IllegalArgumentException("Availability Percentage must be between 85 and 99");
        }

        if (command.launchDate().before(new Date(118, 6, 15)) || command.launchDate().after(new Date())) {
            throw new IllegalArgumentException("Launch Date must be after July 15, 2007 and before the current date");
        }

        ClientId clientId = new ClientId(command.clientId().clientId());
        WebApplication webApplication = new WebApplication(command, clientId);

        try {
            webApplicationRepository.save(webApplication);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving web application: " + e.getMessage());
        }
        return Optional.of(webApplication);
    }
}