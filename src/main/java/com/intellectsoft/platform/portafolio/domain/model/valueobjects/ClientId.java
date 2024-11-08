package com.intellectsoft.platform.portafolio.domain.model.valueobjects;

public record ClientId(Long clientId) {

    public ClientId {
        if (clientId == null || clientId <= 0) {
            throw new IllegalArgumentException("ClientId must be a positive non-null value");
        }
    }
}