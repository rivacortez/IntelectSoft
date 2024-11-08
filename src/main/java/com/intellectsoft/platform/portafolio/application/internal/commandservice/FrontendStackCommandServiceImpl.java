package com.intellectsoft.platform.portafolio.application.internal.commandservice;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateFrontendStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.entities.FrontendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.FrontendStackName;
import com.intellectsoft.platform.portafolio.domain.services.FrontendStackCommandService;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.FrontendStackRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class FrontendStackCommandServiceImpl  implements FrontendStackCommandService {

    private final FrontendStackRepository frontendStackRepository;

    public FrontendStackCommandServiceImpl(FrontendStackRepository frontendStackRepository) {
        this.frontendStackRepository = frontendStackRepository;
    }

    @Override
    public Optional<FrontendStack> handle(CreateFrontendStackCommand command) {
        if (command.id() == null || command.id() <= 0) {
            throw new IllegalArgumentException("Invalid Frontend Stack ID: " + command.id());
        }

        FrontendStackName frontendStackName = command.frontendStack().getName();

        if (frontendStackRepository.existsByName(frontendStackName)) {
            throw new IllegalArgumentException("Frontend Stack with name: " + frontendStackName + " already exists");
        }

        FrontendStack frontendStack = new FrontendStack(frontendStackName);
        try {
            frontendStackRepository.save(frontendStack);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving frontend stack: " + e.getMessage());
        }
        return Optional.of(frontendStack);
    }
}