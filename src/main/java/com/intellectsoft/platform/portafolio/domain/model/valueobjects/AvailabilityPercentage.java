package com.intellectsoft.platform.portafolio.domain.model.valueobjects;

import jakarta.persistence.Embeddable;

/**
 * AvailabilityPercentage Value Object
 * @summary
 * The AvailabilityPercentage class is a value object that represents the availability percentage.
 * It ensures that the value is between 85 and 99.
 * @since 1.0.0
 */
@Embeddable
public class AvailabilityPercentage {
    private int value;

    /**
     * Default constructor.
     * It is required by JPA.
     */
    public AvailabilityPercentage() {}

    /**
     * Constructs a new AvailabilityPercentage with the specified value.
     * @param value - the availability percentage value
     * @throws IllegalArgumentException if the value is not between 85 and 99
     */
    public AvailabilityPercentage(int value) {
        if (value < 85 || value > 99) {
            throw new IllegalArgumentException("AvailabilityPercentage must be between 85 and 99");
        }
        this.value = value;
    }

    /**
     * Returns the availability percentage value.
     * @return the value
     */
    public int getValue() {
        return value;
    }
}