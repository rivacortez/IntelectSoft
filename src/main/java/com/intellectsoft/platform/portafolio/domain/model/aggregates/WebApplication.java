package com.intellectsoft.platform.portafolio.domain.model.aggregates;

import com.intellectsoft.platform.portafolio.domain.model.commands.CreateWebApplicationCommand;
import com.intellectsoft.platform.portafolio.domain.model.events.ApplicationReadyEvent;
import com.intellectsoft.platform.portafolio.domain.model.valueobjects.*;
import com.intellectsoft.platform.shared.domain.model.aggregates.AuditableAbstractAggregateRoot;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;

import java.util.Date;
/**
 * WebApplication Aggregate Root
 *
 * @summary
 * The WebApplication class is an aggregate root that represents a web application.
 * It is responsible for handling the CreateWebApplicationCommand command.
 * @since 1.0.0
 */
@Entity
@Getter
public class WebApplication extends AuditableAbstractAggregateRoot<WebApplication> {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Size(max = 80)
    private String name;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "frontend_address"))
    })
    private WebAddress frontendUrl;

    @NotNull
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "address", column = @Column(name = "backend_address"))
    })
    private WebAddress backendUrl;

    @NotNull
    @Embedded
    private ClientId clientId;

    @NotNull
    @Enumerated(EnumType.STRING)
    private FrontendStackName frontendStack;

    @NotNull
    @Enumerated(EnumType.STRING)
    private BackendStackName backendStack;

    @NotNull
    @Enumerated(EnumType.STRING)
    private CloudPlatformName cloudPlatform;

    @Size(max = 360)
    private String description;

    @NotNull
    @Temporal(TemporalType.TIMESTAMP)
    private Date launchDate;

    @NotNull
    @Embedded
    private AvailabilityPercentage availabilityPercentage;

    @Column(name = "created_at", nullable = false, insertable = false, updatable = false)
    private Date createdAt;

    @Column(name = "updated_at", nullable = false, insertable = false, updatable = false)
    private Date updatedAt;

    public WebApplication() {}

    /**
     * @summary Constructor.
     * It creates a new WebApplication instance based on the CreateWebApplicationCommand command.
     * @param command - the CreateWebApplicationCommand command
     * @param clientId - the ClientId value object
     */
    public WebApplication(CreateWebApplicationCommand command, ClientId clientId) {
        if (command == null || clientId == null) {
            throw new IllegalArgumentException("Command and ClientId cannot be null");
        }
        this.name = command.name();
        this.clientId = clientId;
        this.frontendStack = command.frontendStack();
        this.frontendUrl = command.frontendUrl();
        this.backendStack = command.backendStack();
        this.backendUrl = command.backendUrl();
        this.cloudPlatform = command.cloudPlatform();
        this.description = command.description();
        this.launchDate = command.launchDate();
        this.availabilityPercentage = new AvailabilityPercentage(command.availabilityPercentage());
        this.createdAt = new Date();
        this.updatedAt = new Date();
        this.registerEvent(new ApplicationReadyEvent(this, this.clientId.clientId()));
    }

    @PreUpdate
    protected void onUpdate() {
        this.updatedAt = new Date();
    }
}