package com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories;

import com.intellectsoft.platform.portafolio.domain.model.entities.CloudPlatform;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.CloudPlatformName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CloudStackRepository extends JpaRepository<CloudPlatform, Long> {
    Optional<CloudPlatform> findByName(CloudPlatformName name);
    boolean existsByName(CloudPlatformName name);
}