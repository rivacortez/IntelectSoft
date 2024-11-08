package com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories;

import com.intellectsoft.platform.portafolio.domain.model.entities.BackendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.BackendStackName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BackendStackRepository extends JpaRepository<BackendStack, Long> {
    Optional<BackendStack> findByName(BackendStackName name);
    boolean existsByName(BackendStackName name);
}