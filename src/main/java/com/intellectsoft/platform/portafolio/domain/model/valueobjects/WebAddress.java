package com.intellectsoft.platform.portafolio.domain.model.valueobjects;

import java.util.Objects;

public record WebAddress(String address) {
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