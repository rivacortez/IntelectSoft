package com.intellectsoft.platform.portafolio.domain.model.commands;

import com.intellectsoft.platform.portafolio.domain.model.entities.CloudPlatform;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.CloudPlatformName;
import com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories.CloudStackRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class PopulateCloudStackCommand {

    private final CloudStackRepository cloudStackRepository;

    public PopulateCloudStackCommand(CloudStackRepository cloudStackRepository) {
        this.cloudStackRepository = cloudStackRepository;
    }

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