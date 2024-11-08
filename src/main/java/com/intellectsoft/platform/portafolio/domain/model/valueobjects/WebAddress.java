package com.intellectsoft.platform.portafolio.domain.model.valueobjects;

import java.util.Objects;

/**
 * WebAddress Value Object
 * @summary
 * The WebAddress class is a value object that represents a web address.
 * It ensures that the address is a non-empty string up to 512 characters.
 * @since 1.0.0
 */
public record WebAddress(String address) {
    /**
     * Constructs a new WebAddress with the specified address.
     * @param address - the web address
     * @throws IllegalArgumentException if the address is null, blank, or longer than 512 characters
     */
    public WebAddress {
        if (address == null || address.isBlank() || address.length() > 512) {
            throw new IllegalArgumentException("WebAddress must be a non-empty string up to 512 characters");
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WebAddress that = (WebAddress) o;
        return Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(address);
    }
}