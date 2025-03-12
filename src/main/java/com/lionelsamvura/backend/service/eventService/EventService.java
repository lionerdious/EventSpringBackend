package com.lionelsamvura.backend.service.eventService;

import java.util.List;

public interface EventService {

    /**
     * This method returns event with id passed
     * @param id id used to retrieve event
     * @return EventResponse DTO of event with id passed
     */
    EventResponse findById(Long id);

    /**
     * This method creates an event based off of the event request DTO passed
     * @param eventRequest dto used to create event
     * @return dto of created event
     */
    EventResponse create(EventRequest eventRequest);

    /**
     * This method updates an event with the passed id
     * @param id id of the event that is supposed to be updated
     * @param eventRequest dto used to update the event
     * @return event response DTO of the updated event
     */
    EventResponse update(Long id, EventRequest eventRequest);

    /**
     * This method deletes an event based on the id passed
     * @param id
     */
    void delete(Long id);

    /**
     * This method returns all events
     * @return
     */
    List<EventResponse> findAll();
}
