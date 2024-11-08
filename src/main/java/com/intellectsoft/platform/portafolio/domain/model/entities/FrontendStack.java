package com.intellectsoft.platform.portafolio.domain.model.entities;

import com.intellectsoft.platform.portafolio.domain.model.valueobjects.FrontendStackName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * FrontendStack Entity
 * @summary
 * The FrontendStack class is an entity that represents a frontend stack.
 * It contains the ID and name of the frontend stack.
 * @since 1.0.0
 */
@Entity
@Getter
public class FrontendStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FrontendStackName name;

    /**
     * Default constructor.
     * It is required by JPA.
     */
    public FrontendStack() {}

    /**
     * Constructs a new FrontendStack with the specified name.
     * @param name - the name of the frontend stack
     */
    public FrontendStack(FrontendStackName name) {
        this.name = name;
    }
}