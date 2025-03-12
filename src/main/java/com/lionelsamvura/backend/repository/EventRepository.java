package com.lionelsamvura.backend.repository;

import com.lionelsamvura.backend.domain.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
