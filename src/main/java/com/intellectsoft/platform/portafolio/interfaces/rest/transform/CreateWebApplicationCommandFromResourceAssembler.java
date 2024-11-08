package com.intellectsoft.platform.portafolio.interfaces.rest.transform;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateWebApplicationCommand;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.ClientId;
import com.intellectsoft.platform.portafolio.interfaces.rest.resources.CreateWebApplicationResource;


public class CreateWebApplicationCommandFromResourceAssembler {

    public static CreateWebApplicationCommand toCommandFromResource(CreateWebApplicationResource resource) {
        return new CreateWebApplicationCommand(
                resource.name(),
                new ClientId(resource.clientId()),
                resource.frontendStack(),
                resource.frontendUrl(),
                resource.backendStack(),
                resource.backendUrl(),
                resource.cloudPlatform(),
                resource.description(),
                resource.availabilityPercentage(),
                resource.launchDate()
        );
    }
}