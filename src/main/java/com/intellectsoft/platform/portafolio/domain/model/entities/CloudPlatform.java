package com.intellectsoft.platform.portafolio.domain.model.entities;

import com.intellectsoft.platform.portafolio.domain.model.valueobjects.CloudPlatformName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class CloudPlatform {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CloudPlatformName name;

    public CloudPlatform() {}

    public CloudPlatform(CloudPlatformName name) {
        this.name = name;
    }
}
