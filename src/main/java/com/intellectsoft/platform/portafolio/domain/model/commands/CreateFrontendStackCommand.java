package com.intellectsoft.platform.portafolio.domain.model.commands;

import com.intellectsoft.platform.portafolio.domain.model.entities.FrontendStack;

public record CreateFrontendStackCommand(Long id, FrontendStack frontendStack) {
}
