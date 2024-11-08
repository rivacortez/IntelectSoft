package com.intellectsoft.platform.portafolio.interfaces.rest.resources;

import com.intellectsoft.platform.portafolio.domain.model.valueobjects.BackendStackName;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.CloudPlatformName;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.FrontendStackName;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.WebAddress;

import java.util.Date;

public record CreateWebApplicationResource(

        String name,
        Long clientId,
        FrontendStackName frontendStack,
        WebAddress frontendUrl,
        BackendStackName backendStack,
        WebAddress backendUrl,
        CloudPlatformName cloudPlatform,
        String description,
        int availabilityPercentage,
        Date launchDate
) {
}