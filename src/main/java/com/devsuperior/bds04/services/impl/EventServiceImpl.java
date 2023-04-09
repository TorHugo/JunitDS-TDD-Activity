package com.devsuperior.bds04.services.impl;

import com.devsuperior.bds04.exception.impl.DataBaseException;
import com.devsuperior.bds04.exception.impl.ResourceNotFoundException;
import com.devsuperior.bds04.model.dto.EventDTO;
import com.devsuperior.bds04.model.entities.Event;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.repositories.EventRepository;
import com.devsuperior.bds04.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.time.LocalDate;

@Service
public class EventServiceImpl implements EventService {

    @Autowired
    private EventRepository repository;

    @Autowired
    private CityRepository cityRepository;

    public Page<EventDTO> findAllPaged(Pageable pageable) {
        Page<Event> list = repository.findAll(pageable);

        return list.map(EventDTO::new);
    }

    @Override
    public EventDTO save(EventDTO dto) {
        Event event = mapperToEntity(dto);
        return new EventDTO(repository.save(event));
    }

    private Event mapperToEntity(EventDTO dto) {
        Event entity = new Event();
        entity.setName(dto.getName());
        entity.setDate(dto.getDate());
        entity.setUrl(dto.getUrl());
        entity.setCity(
                cityRepository.findById(dto.getCityId()).orElseThrow(() -> new DataBaseException("Entity not found."))
        );
        return entity;
    }
}
