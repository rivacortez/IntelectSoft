package com.intellectsoft.platform.portafolio.domain.model.entities;

import com.intellectsoft.platform.portafolio.domain.model.valueobjects.BackendStackName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class BackendStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BackendStackName name;

    public BackendStack() {}

    public BackendStack(BackendStackName name) {
        this.name = name;
    }
}
