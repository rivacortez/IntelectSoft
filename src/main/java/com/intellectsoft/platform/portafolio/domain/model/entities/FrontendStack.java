package com.intellectsoft.platform.portafolio.domain.model.entities;

import com.intellectsoft.platform.portafolio.domain.model.valueobjects.FrontendStackName;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Getter
public class FrontendStack {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @NotNull
    @Enumerated(EnumType.STRING)
    private FrontendStackName name;

    public FrontendStack() {}

    public FrontendStack(FrontendStackName name) {
        this.name = name;
    }
}
