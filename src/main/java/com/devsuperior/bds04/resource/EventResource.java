package com.devsuperior.bds04.resource;

import com.devsuperior.bds04.model.dto.EventDTO;
import com.devsuperior.bds04.services.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/events")
public class EventResource {

    @Autowired
    private EventService service;

    @GetMapping
    public ResponseEntity<Page<EventDTO>> findAllPageable(Pageable pageable){
        Page<EventDTO> list = service.findAllPaged(pageable);
        return ResponseEntity.ok().body(list);
    }

    @PostMapping
    public ResponseEntity<EventDTO> save(
            @RequestBody @Valid EventDTO dto
    ){
        EventDTO eventDTO = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(eventDTO);
    }
}
