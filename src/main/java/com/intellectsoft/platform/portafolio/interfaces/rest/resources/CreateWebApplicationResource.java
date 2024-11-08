package com.intellectsoft.platform.portafolio.interfaces.rest.resources;

import com.intellectsoft.platform.portafolio.domain.model.valueobjects.BackendStackName;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.CloudPlatformName;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.FrontendStackName;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.WebAddress;

import java.util.Date;

/**
 * CreateWebApplicationResource
 * @summary
 * CreateWebApplicationResource is a record class that represents the data required to create a new WebApplication.
 * @param name - the name of the WebApplication.
 * @param clientId - the ID of the client.
 * @param frontendStack - the frontend stack name of the WebApplication.
 * @param frontendUrl - the frontend URL of the WebApplication.
 * @param backendStack - the backend stack name of the WebApplication.
 * @param backendUrl - the backend URL of the WebApplication.
 * @param cloudPlatform - the cloud platform name of the WebApplication.
 * @param description - the description of the WebApplication.
 * @param availabilityPercentage - the availability percentage of the WebApplication.
 * @param launchDate - the launch date of the WebApplication.
 * @since 1.0.0
 */
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