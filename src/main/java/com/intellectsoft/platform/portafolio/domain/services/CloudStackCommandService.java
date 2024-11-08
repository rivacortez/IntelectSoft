package com.intellectsoft.platform.portafolio.domain.services;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateCloudPlatformStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.entities.CloudPlatform;

import java.util.Optional;

public interface CloudStackCommandService {
    Optional<CloudPlatform> handle(CreateCloudPlatformStackCommand command);
}
