package com.bienncanasa.eventapp.controller;

import com.bienncanasa.eventapp.model.Event;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import com.bienncanasa.eventapp.repository.EventRepository;

import com.bienncanasa.eventapp.service.EventService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class HomeController {
    private final EventService eventService;

    public HomeController(EventService eventService) {
        this.eventService = eventService;
    }

    @GetMapping("/save")
    public Event saveEvent() {
        Event event = new Event(
                "Champions League Final",
                "Munich"
        );
        return eventService.createEvent(event);
    }

    @GetMapping("/")
    public String home() {
        return "Event App is running!";
    }

    @GetMapping("/hello")
    public String hello() {
        return "Hello from Spring Boot!";
    }

    @GetMapping("/event")
    public Event getEvent() {
        return new Event(
                "Champions League Final",
                "Munich"
        );
    }

    @GetMapping("/events")
    public List<Event> getEvents() {
        return eventService.getAllEvents();
    }

    @GetMapping("/events/{id}")
    public Optional<Event> getEventById(@PathVariable Long id) {
        return eventService.getEventById(id);
    }

    @PostMapping("/events")
    public Event createEvent(@RequestBody Event event) {
        return eventService.createEvent(event);
    }

    @DeleteMapping("/events/{id}")
    public String deleteEvent(@PathVariable Long id) {
        eventService.deleteEvent(id);
        return "Event deleted successfully";
    }

    @PutMapping("/events/{id}")
    public Event updateEvent(
            @PathVariable Long id,
            @RequestBody Event updatedEvent
    ) {

        return eventService.updateEvent(id, updatedEvent);
    }

}
