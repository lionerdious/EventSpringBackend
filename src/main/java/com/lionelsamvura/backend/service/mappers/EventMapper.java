package com.lionelsamvura.backend.service.mappers;

import com.lionelsamvura.backend.domain.Event;
import com.lionelsamvura.backend.service.eventService.EventResponse;

public interface EventMapper {

    static EventResponse demoToDemoResponseMapper(Event event){
        return new EventResponse(event.getId(), event.getTitle(), event.getBody());
    }
}
