package com.intellectsoft.platform.portafolio.domain.services;

import com.intellectsoft.platform.portafolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.portafolio.domain.model.commands.CreateWebApplicationCommand;

import java.util.Optional;

public interface WebApplicationCommandService {
    Optional<WebApplication> handle(CreateWebApplicationCommand command);
}
