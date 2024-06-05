package org.example.gymkhanabackend.controller;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.example.gymkhanabackend.entity.Event;
import org.example.gymkhanabackend.repo.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@RestController
@RequestMapping("/events")

public class EventController {

    @Autowired
    private EventRepo eventRepository;

    @GetMapping
    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    @PostMapping
    public Event createEvent(@RequestBody Event event) {
        return eventRepository.save(event);
    }

    @PutMapping("/{id}")
    public Event updateEvent(@PathVariable Long id, @RequestBody Event eventDetails) {
        Optional<Event> optionalEvent = eventRepository.findById(id);
        if (optionalEvent.isPresent()) {
            Event event = optionalEvent.get();
            event.setTitle(eventDetails.getTitle());
            event.setDescription(eventDetails.getDescription());
            event.setLabel(eventDetails.getLabel());
            event.setDay(eventDetails.getDay());
            return eventRepository.save(event);
        } else {
            System.out.println("Event not found");
            return null;
        }
    }

    @DeleteMapping("/{id}")
    public void deleteEvent(@PathVariable Long id) {
        eventRepository.deleteById(id);
    }
}
