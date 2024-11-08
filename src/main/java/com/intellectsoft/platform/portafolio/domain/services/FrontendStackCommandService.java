package com.intellectsoft.platform.portafolio.domain.services;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateFrontendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.entities.FrontendStack;

import java.util.Optional;

public interface FrontendStackCommandService {
    Optional<FrontendStack>    handle(CreateFrontendStackCommand command);
}
