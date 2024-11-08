package com.intellectsoft.platform.portafolio.interfaces.rest.transform;

import com.intellectsoft.platform.portafolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.portafolio.interfaces.rest.resources.WebApplicationResource;

/**
 * WebApplicationFromEntityAssembler
 * @summary
 * WebApplicationFromEntityAssembler is a utility class that provides a method to convert a WebApplication entity to a WebApplicationResource.
 * @since 1.0.0
 */
public class WebApplicationFromEntityAssembler {

    /**
     * Converts a WebApplication entity to a WebApplicationResource.
     * @param entity - the WebApplication entity to be converted.
     * @return a WebApplicationResource with the data from the entity.
     */
    public static WebApplicationResource toResourceFromEntity(WebApplication entity) {
        return new WebApplicationResource(
                entity.getId(),
                entity.getName(),
                entity.getClientId().clientId(),
                entity.getFrontendStack(),
                entity.getFrontendUrl(),
                entity.getBackendStack(),
                entity.getBackendUrl(),
                entity.getCloudPlatform(),
                entity.getDescription(),
                entity.getAvailabilityPercentage().getValue(),
                entity.getLaunchDate()
        );
    }
}