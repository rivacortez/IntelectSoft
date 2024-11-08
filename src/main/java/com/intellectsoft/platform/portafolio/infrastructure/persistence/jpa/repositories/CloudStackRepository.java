package com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories;

import com.intellectsoft.platform.portafolio.domain.model.entities.CloudPlatform;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.CloudPlatformName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * CloudStackRepository Interface
 * @summary
 * The CloudStackRepository interface provides methods to perform CRUD operations on CloudPlatform entities.
 * It extends JpaRepository to leverage Spring Data JPA functionalities.
 * @since 1.0.0
 */
@Repository
public interface CloudStackRepository extends JpaRepository<CloudPlatform, Long> {
    /**
     * Finds a CloudPlatform by its name.
     * @param name - the name of the CloudPlatform
     * @return an Optional containing the found CloudPlatform, or an empty Optional if no CloudPlatform was found
     */
    Optional<CloudPlatform> findByName(CloudPlatformName name);

    /**
     * Checks if a CloudPlatform with the given name exists.
     * @param name - the name of the CloudPlatform
     * @return true if a CloudPlatform with the given name exists, false otherwise
     */
    boolean existsByName(CloudPlatformName name);
}