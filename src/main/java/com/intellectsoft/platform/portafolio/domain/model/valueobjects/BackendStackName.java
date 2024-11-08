package com.intellectsoft.platform.portafolio.domain.model.valueobjects;

public enum BackendStackName {
    SPRING_BOOT("Spring Boot"),
    DOT_NET(".NET"),
    NODEJS("Node.js");

    private final String displayName;

    BackendStackName(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}