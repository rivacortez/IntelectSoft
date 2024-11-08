package com.intellectsoft.platform.portafolio.domain.model.commands;

import com.intellectsoft.platform.portafolio.domain.model.entities.CloudPlatform;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.CloudPlatformName;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.CloudStackRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

/**
 * PopulateCloudStackCommand
 * @summary
 * PopulateCloudStackCommand is a service class responsible for populating the cloud stack repository with predefined cloud platform names.
 * It ensures that each cloud platform name is saved in the repository if it does not already exist.
 * @see CloudStackRepository
 * @since 1.0.0
 */
@Service
public class PopulateCloudStackCommand {

    private final CloudStackRepository cloudStackRepository;

    /**
     * Constructs a new PopulateCloudStackCommand with the specified repository.
     * @param cloudStackRepository - the repository for cloud platforms
     */
    public PopulateCloudStackCommand(CloudStackRepository cloudStackRepository) {
        this.cloudStackRepository = cloudStackRepository;
    }

    /**
     * Handles the population of cloud platforms.
     * This method is called after the bean's properties have been set.
     * It iterates through all predefined cloud platform names and saves them in the repository if they do not already exist.
     */
    @PostConstruct
    public void handle() {
        List<CloudPlatformName> cloudPlatformNames = Arrays.asList(CloudPlatformName.values());

        for (CloudPlatformName platformName : cloudPlatformNames) {
            if (cloudStackRepository.findByName(platformName).isEmpty()) {
                CloudPlatform cloudPlatform = new CloudPlatform(platformName);
                cloudStackRepository.save(cloudPlatform);
            }
        }
    }
}