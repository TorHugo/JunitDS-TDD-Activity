package com.devsuperior.bds04.services;

import com.devsuperior.bds04.model.dto.EventDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

@Component
public interface EventService {
    Page<EventDTO> findAllPaged(Pageable pageable);

    EventDTO save(EventDTO dto);
}
