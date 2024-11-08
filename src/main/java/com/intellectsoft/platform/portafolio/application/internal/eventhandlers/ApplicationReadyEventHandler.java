package com.intellectsoft.platform.portafolio.application.internal.eventhandlers;

import com.intellectsoft.platform.portafolio.domain.model.commands.PopulateBackendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.commands.PopulateCloudStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.commands.PopulateFrontendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.events.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ApplicationReadyEventHandler {

    private final PopulateBackendStackCommand populateBackendStackCommand;
    private final PopulateCloudStackCommand populateCloudStackCommand;
    private final PopulateFrontendStackCommand populateFrontendStackCommand;

    public ApplicationReadyEventHandler(PopulateBackendStackCommand populateBackendStackCommand,
                                        PopulateCloudStackCommand populateCloudStackCommand,
                                        PopulateFrontendStackCommand populateFrontendStackCommand) {
        this.populateBackendStackCommand = populateBackendStackCommand;
        this.populateCloudStackCommand = populateCloudStackCommand;
        this.populateFrontendStackCommand = populateFrontendStackCommand;
    }

    @EventListener
    public void onApplicationEvent(ApplicationReadyEvent event) {
        populateBackendStackCommand.handle();
        populateCloudStackCommand.handle();
        populateFrontendStackCommand.handle();
    }
}