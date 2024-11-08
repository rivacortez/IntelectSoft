package com.intellectsoft.platform.portafolio.domain.model.commands;

import com.intellectsoft.platform.portafolio.domain.model.valueobjects.*;

import java.util.Date;

public record CreateWebApplicationCommand(
        String name,
        ClientId clientId,
        FrontendStackName frontendStack,
        WebAddress frontendUrl,
        BackendStackName backendStack,
        WebAddress backendUrl,
        CloudPlatformName cloudPlatform,
        String description,
        int availabilityPercentage,
        Date launchDate
) {}