package com.intellectsoft.platform.portafolio.application.internal.eventhandlers;

import com.intellectsoft.platform.portafolio.domain.model.commands.PopulateBackendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.commands.PopulateCloudStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.commands.PopulateFrontendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.events.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

/**
 * ApplicationReadyEventHandler
 * @summary
 * The ApplicationReadyEventHandler class is responsible for handling the ApplicationReadyEvent.
 * It triggers the population of backend, cloud, and frontend stacks when the application is ready.
 * @see ApplicationReadyEvent
 * @since 1.0.0
 */
@Component
public class ApplicationReadyEventHandler {

    private final PopulateBackendStackCommand populateBackendStackCommand;
    private final PopulateCloudStackCommand populateCloudStackCommand;
    private final PopulateFrontendStackCommand populateFrontendStackCommand;

    /**
     * Constructs a new ApplicationReadyEventHandler with the specified commands.
     * @param populateBackendStackCommand the command to populate backend stacks
     * @param populateCloudStackCommand the command to populate cloud stacks
     * @param populateFrontendStackCommand the command to populate frontend stacks
     */
    public ApplicationReadyEventHandler(PopulateBackendStackCommand populateBackendStackCommand,
                                        PopulateCloudStackCommand populateCloudStackCommand,
                                        PopulateFrontendStackCommand populateFrontendStackCommand) {
        this.populateBackendStackCommand = populateBackendStackCommand;
        this.populateCloudStackCommand = populateCloudStackCommand;
        this.populateFrontendStackCommand = populateFrontendStackCommand;
    }

    /**
     * Handles the ApplicationReadyEvent by triggering the population of backend, cloud, and frontend stacks.
     * @param event the ApplicationReadyEvent
     */
    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        populateBackendStackCommand.handle();
        populateCloudStackCommand.handle();
        populateFrontendStackCommand.handle();
    }
}