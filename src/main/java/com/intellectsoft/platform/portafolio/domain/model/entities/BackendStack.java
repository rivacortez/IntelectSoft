package com.intellectsoft.platform.portafolio.domain.model.entities;

import com.intellectsoft.platform.portafolio.domain.model.valueobjects.BackendStackName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

/**
 * BackendStack Entity
 * @summary
 * The BackendStack class is an entity that represents a backend stack.
 * It contains the ID and name of the backend stack.
 * @since 1.0.0
 */
@Entity
@Getter
public class BackendStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BackendStackName name;

    /**
     * Default constructor.
     * It is required by JPA.
     */
    public BackendStack() {}

    /**
     * Constructs a new BackendStack with the specified name.
     * @param name - the name of the backend stack
     */
    public BackendStack(BackendStackName name) {
        this.name = name;
    }
}