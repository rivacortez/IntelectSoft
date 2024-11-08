package com.intellectsoft.platform.portafolio.infrastructure.persistence.jpa.repositories;

import com.intellectsoft.platform.portafolio.domain.model.entities.FrontendStack;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.FrontendStackName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface FrontendStackRepository extends JpaRepository<FrontendStack, Long> {
    Optional<FrontendStack> findByName(FrontendStackName name);
    boolean existsByName(FrontendStackName name);
}