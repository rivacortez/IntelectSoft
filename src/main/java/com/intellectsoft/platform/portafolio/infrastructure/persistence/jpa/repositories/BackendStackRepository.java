package com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories;

import com.intellectsoft.platform.portafolio.domain.model.entities.BackendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.BackendStackName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

/**
 * BackendStackRepository Interface
 * @summary
 * The BackendStackRepository interface provides methods to perform CRUD operations on BackendStack entities.
 * It extends JpaRepository to leverage Spring Data JPA functionalities.
 * @since 1.0.0
 */
@Repository
public interface BackendStackRepository extends JpaRepository<BackendStack, Long> {
    /**
     * Finds a BackendStack by its name.
     * @param name - the name of the BackendStack
     * @return an Optional containing the found BackendStack, or an empty Optional if no BackendStack was found
     */
    Optional<BackendStack> findByName(BackendStackName name);

    /**
     * Checks if a BackendStack with the given name exists.
     * @param name - the name of the BackendStack
     * @return true if a BackendStack with the given name exists, false otherwise
     */
    boolean existsByName(BackendStackName name);
}