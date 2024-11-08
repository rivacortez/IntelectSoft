package com.intellectsoft.platform.portafolio.interfaces.rest.transform;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateWebApplicationCommand;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.ClientId;
import com.intellectsoft.platform.portafolio.interfaces.rest.resources.CreateWebApplicationResource;


/**
 * CreateWebApplicationCommandFromResourceAssembler
 * @summary
 * CreateWebApplicationCommandFromResourceAssembler is a utility class that provides a method to convert a CreateWebApplicationResource to a CreateWebApplicationCommand.
 * @since 1.0.0
 */
public class CreateWebApplicationCommandFromResourceAssembler {

    /**
     * Converts a CreateWebApplicationResource to a CreateWebApplicationCommand.
     * @param resource - the CreateWebApplicationResource to be converted.
     * @return a CreateWebApplicationCommand with the data from the resource.
     */
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