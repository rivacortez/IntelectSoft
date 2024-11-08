package com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories;

import com.intellectsoft.platform.portafolio.domain.model.aggregates.WebApplication;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.WebAddress;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WebApplicationRepository  extends JpaRepository<WebApplication, Long> {
    boolean existsByFrontendUrlOrBackendUrl(WebAddress frontendUrl, WebAddress backendUrl);
}