package com.intellectsoft.platform.portafolio.interfaces.rest;

import com.intellectsoft.platform.portafolio.domain.services.WebApplicationCommandService;
import com.intellectsoft.platform.portafolio.interfaces.rest.resources.CreateWebApplicationResource;
import com.intellectsoft.platform.portafolio.interfaces.rest.resources.WebApplicationResource;
import com.intellectsoft.platform.portafolio.interfaces.rest.transform.CreateWebApplicationCommandFromResourceAssembler;
import com.intellectsoft.platform.portafolio.interfaces.rest.transform.WebApplicationFromEntityAssembler;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * WebApplicationController
 *
 * @summary WebApplicationController is a class that represents the REST controller for the web applications. It depends on the WebApplicationCommandService.
 * This class contains the REST endpoints for the web applications.
 * The endpoints allow to:
 * <ul>
 * <li>Create a web application</li>
 * </ul>
 * @see WebApplicationCommandService
 * @since 1.0.0
 */
@RestController
@RequestMapping(value="/api/v1/WebApplication", produces = APPLICATION_JSON_VALUE)
@Tag(name = "WebApplication", description = "WebApplication Endpoints")
public class WebApplicationController {

    private final WebApplicationCommandService webApplicationCommandService;

    public WebApplicationController(WebApplicationCommandService webApplicationCommandService) {
        this.webApplicationCommandService = webApplicationCommandService;
    }

    /**
     * Creates a new web application.
     *
     * @param resource the CreateWebApplicationResource containing the data for the new web application.
     * @return a ResponseEntity containing the created WebApplicationResource and HTTP status code.
     */
    @Operation(
            summary = "Create a new web application",
            description = "Creates a new web application with the data provided in the request body.")

    @PostMapping
    public ResponseEntity<WebApplicationResource> createPlant(@RequestBody CreateWebApplicationResource resource) {
        var createPlantCommand = CreateWebApplicationCommandFromResourceAssembler.toCommandFromResource(resource);
        var webApplication = webApplicationCommandService.handle(createPlantCommand);
        if (webApplication.isEmpty()) return ResponseEntity.badRequest().build();
        var webApplicationResource = WebApplicationFromEntityAssembler.toResourceFromEntity(webApplication.get());
        return new ResponseEntity<>(webApplicationResource, HttpStatus.CREATED);
    }
}