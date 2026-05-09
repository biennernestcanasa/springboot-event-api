package com.bienncanasa.eventapp.repository;

import com.bienncanasa.eventapp.model.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {

}