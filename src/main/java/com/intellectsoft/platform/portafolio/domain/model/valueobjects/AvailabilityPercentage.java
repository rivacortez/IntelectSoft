package com.intellectsoft.platform.portafolio.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

@Embeddable

public class AvailabilityPercentage {
    private int value;

    public AvailabilityPercentage() {

    }

    public AvailabilityPercentage(int value) {
        if (value < 85 || value > 99) {
            throw new IllegalArgumentException("AvailabilityPercentage must be between 85 and 99");
        }
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}