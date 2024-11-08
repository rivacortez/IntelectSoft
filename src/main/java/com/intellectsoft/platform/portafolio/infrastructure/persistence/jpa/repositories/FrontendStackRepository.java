package com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories;

import com.intellectsoft.platform.portafolio.domain.model.entities.FrontendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.FrontendStackName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * FrontendStackRepository Interface
 * @summary
 * The FrontendStackRepository interface provides methods to perform CRUD operations on FrontendStack entities.
 * It extends JpaRepository to leverage Spring Data JPA functionalities.
 * @since 1.0.0
 */
@Repository
public interface FrontendStackRepository extends JpaRepository<FrontendStack, Long> {
    /**
     * Finds a FrontendStack by its name.
     * @param name - the name of the FrontendStack
     * @return an Optional containing the found FrontendStack, or an empty Optional if no FrontendStack was found
     */
    Optional<FrontendStack> findByName(FrontendStackName name);

    /**
     * Checks if a FrontendStack with the given name exists.
     * @param name - the name of the FrontendStack
     * @return true if a FrontendStack with the given name exists, false otherwise
     */
    boolean existsByName(FrontendStackName name);
}