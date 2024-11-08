package com.intellectsoft.platform.portafolio.domain.model.entities;

import com.intellectsoft.platform.portafolio.domain.model.valueobjects.CloudPlatformName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * CloudPlatform Entity
 * @summary
 * The CloudPlatform class is an entity that represents a cloud platform.
 * It contains the ID and name of the cloud platform.
 * @since 1.0.0
 */
@Entity
@Getter
public class CloudPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CloudPlatformName name;

    /**
     * Default constructor.
     * It is required by JPA.
     */
    public CloudPlatform() {}

    /**
     * Constructs a new CloudPlatform with the specified name.
     * @param name - the name of the cloud platform
     */
    public CloudPlatform(CloudPlatformName name) {
        this.name = name;
    }
}