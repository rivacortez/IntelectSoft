package com.intellectsoft.platform.portafolio.domain.services;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateBackendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.entities.BackendStack;

import java.util.Optional;

public interface BackendStackCommandService {
    Optional<BackendStack> handle(CreateBackendStackCommand command);
}
