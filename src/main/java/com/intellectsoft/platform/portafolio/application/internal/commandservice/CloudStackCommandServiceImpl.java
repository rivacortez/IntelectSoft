package com.intellectsoft.platform.portafolio.application.internal.commandservice;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateCloudPlatformStackCommand;
import com.intellectsoft.platform.portafolio.domain.model.entities.CloudPlatform;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.CloudPlatformName;
import com.intellectsoft.platform.portafolio.domain.services.CloudStackCommandService;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.CloudStackRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;
/**
 * CloudStackCommandServiceImpl
 * @summary
 * The CloudStackCommandServiceImpl class is responsible for handling the cloud stack commands.
 * It implements the CloudStackCommandService interface.
 * @see CloudStackCommandService
 * @since 1.0.0
 */
@Service
public class CloudStackCommandServiceImpl implements CloudStackCommandService {

    private final CloudStackRepository cloudStackRepository;

    public CloudStackCommandServiceImpl(CloudStackRepository cloudStackRepository) {
        this.cloudStackRepository = cloudStackRepository;
    }

    // @inheritdoc
    @Override
    public Optional<CloudPlatform> handle(CreateCloudPlatformStackCommand command) {
        if (command.id() == null || command.id() <= 0) {
            throw new IllegalArgumentException("Invalid Cloud Platform ID: " + command.id());
        }

        CloudPlatformName cloudPlatformName = command.cloudPlatform().getName();

        if (cloudStackRepository.existsByName(cloudPlatformName)) {
            throw new IllegalArgumentException("Cloud Platform with name: " + cloudPlatformName + " already exists");
        }

        CloudPlatform cloudPlatform = new CloudPlatform(cloudPlatformName);
        try {
            cloudStackRepository.save(cloudPlatform);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error while saving cloud platform: " + e.getMessage());
        }
        return Optional.of(cloudPlatform);
    }
}