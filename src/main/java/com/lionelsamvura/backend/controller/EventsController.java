package com.lionelsamvura.backend.controller;

import com.lionelsamvura.backend.service.eventService.EventRequest;
import com.lionelsamvura.backend.service.eventService.EventResponse;
import com.lionelsamvura.backend.service.eventService.EventService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/event")
@RequiredArgsConstructor
@Tag( name = "Event",
      description = "These endpoints are for the Events"  )
public class EventsController {

    private final EventService eventService;

    @PostMapping
    @Operation( summary = "Create a event record",
                description = "This endpoints creates demo record",
                responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created demo",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EventResponse.class)
                            )
                    )
                })
    public ResponseEntity<EventResponse> create(@Valid @RequestBody EventRequest eventRequest){
        return new ResponseEntity<>(eventService.create(eventRequest), HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    @Operation( summary = "Create a event record",
            description = "This endpoints creates demo record",
            responses = {
                    @ApiResponse(
                            responseCode = "201",
                            description = "Created demo",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EventResponse.class)
                            )
                    )
            })
    public ResponseEntity<EventResponse> update(@Valid @RequestBody EventRequest eventRequest, @PathVariable Long id){
        return new ResponseEntity<>(eventService.update(id, eventRequest), HttpStatus.CREATED);
    }

    @GetMapping
    @Operation( summary = "Gets all Event's",
            description = "This endpoints returns all events",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ok",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EventResponse[].class)
                            )
                    )
            })
    public ResponseEntity<List<EventResponse>> findAll(){
        return new ResponseEntity<>(eventService.findAll(), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    @Operation( summary = "Finds one by id",
            description = "This endpoints returns one event by event id",
            responses = {
                    @ApiResponse(
                            responseCode = "200",
                            description = "Ok",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EventResponse[].class)
                            )
                    )
            })
    public ResponseEntity<EventResponse> findById(@PathVariable Long id){
        return new ResponseEntity<>(eventService.findById(id), HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    @Operation( summary = "Deletes event with passed id",
            description = "This endpoints deletes an event with the passed id",
            responses = {
                    @ApiResponse(
                            responseCode = "204",
                            description = "Ok",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(implementation = EventResponse[].class)
                            )
                    )
            })
    public ResponseEntity<?> delete(@PathVariable Long id){
        eventService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
