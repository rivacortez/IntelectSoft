package com.intellectsoft.platform.portafolio.interfaces.rest.transform;

import com.intellectsoft.platform.portafolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.portafolio.interfaces.rest.resources.WebApplicationResource;

public class WebApplicationFromEntityAssembler {

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