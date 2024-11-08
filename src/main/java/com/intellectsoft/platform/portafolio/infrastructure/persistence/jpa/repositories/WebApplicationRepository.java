package com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories;

import com.intellectsoft.platform.portafolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.WebAddress;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * WebApplicationRepository Interface
 * @summary
 * The WebApplicationRepository interface provides methods to perform CRUD operations on WebApplication entities.
 * It extends JpaRepository to leverage Spring Data JPA functionalities.
 * @since 1.0.0
 */
public interface WebApplicationRepository  extends JpaRepository<WebApplication, Long> {
    /**
     * Checks if a WebApplication with the given frontend or backend URL exists.
     * @param frontendUrl - the frontend URL of the WebApplication
     * @param backendUrl - the backend URL of the WebApplication
     * @return true if a WebApplication with the given frontend or backend URL exists, false otherwise
     */
    boolean existsByFrontendUrlOrBackendUrl(WebAddress frontendUrl, WebAddress backendUrl);
}