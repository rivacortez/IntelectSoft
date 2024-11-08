package com.intellectsoft.platform.portafolio.domain.model.events;

import com.intellectsoft.platform.portafolio.domain.model.aggregates.WebApplication;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * ApplicationReadyEvent
 * @summary
 * The ApplicationReadyEvent class represents an event that is triggered when a web application is ready.
 * It contains the client ID associated with the event.
 * @since 1.0.0
 */
@Getter
public class ApplicationReadyEvent extends ApplicationEvent {
    private final Long clientId;

    /**
     * Constructs a new ApplicationReadyEvent with the specified web application and client ID.
     * @param webApplication - the web application that triggered the event
     * @param clientId - the ID of the client associated with the event
     */
    public ApplicationReadyEvent(WebApplication webApplication, Long clientId) {
        super(webApplication);
        this.clientId = clientId;
    }
}