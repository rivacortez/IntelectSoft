package com.intellectsoft.platform.portafolio.domain.model.commands;

import com.intellectsoft.platform.portafolio.domain.model.entities.CloudPlatform;

public record CreateCloudPlatformStackCommand(Long id, CloudPlatform cloudPlatform) {
}
