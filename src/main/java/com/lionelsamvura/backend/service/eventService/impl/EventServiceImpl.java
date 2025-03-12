package com.lionelsamvura.backend.service.eventService.impl;

import com.lionelsamvura.backend.domain.Event;
import com.lionelsamvura.backend.repository.EventRepository;
import com.lionelsamvura.backend.service.eventService.EventRequest;
import com.lionelsamvura.backend.service.eventService.EventResponse;
import com.lionelsamvura.backend.service.eventService.EventService;
import com.lionelsamvura.backend.service.exception.ResourceNotFoundException;
import com.lionelsamvura.backend.service.mappers.EventMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EventServiceImpl implements EventService {

    private final EventRepository eventRepository;

    @Override
    public EventResponse findById(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Event with id %s not found", id)
                ));
        return EventMapper.demoToDemoResponseMapper(event);
    }

    @Override
    public EventResponse create(EventRequest eventRequest) {
        Event event =  Event.builder()
                .title(eventRequest.title())
                .body(eventRequest.body())
                .build();
        eventRepository.save(event);
        return EventMapper.demoToDemoResponseMapper(event);
    }

    @Override
    public EventResponse update(Long id, EventRequest eventRequest) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Event with id %s not found", id)
                ));
        event.setTitle(eventRequest.title());
        event.setBody(eventRequest.body());
        eventRepository.save(event);
        return EventMapper.demoToDemoResponseMapper(event);
    }

    @Override
    public void delete(Long id) {
        Event event = eventRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException(
                        String.format("Event with id %s not found", id)
                ));
        eventRepository.delete(event);
    }

    @Override
    public List<EventResponse> findAll() {
       return eventRepository.findAll()
               .stream()
               .map(EventMapper::demoToDemoResponseMapper)
               .toList();
    }
}
