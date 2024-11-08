package com.intellectsoft.platform.portafolio.domain.model.events;

import com.intellectsoft.platform.portafolio.domain.model.aggregates.WebApplication;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

@Getter
public class ApplicationReadyEvent extends ApplicationEvent {
    private final Long clientId;

    public ApplicationReadyEvent(WebApplication webApplication, Long clientId) {
        super(webApplication);
        this.clientId = clientId;
    }
}