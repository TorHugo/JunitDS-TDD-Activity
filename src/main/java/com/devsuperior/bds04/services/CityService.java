package com.devsuperior.bds04.services;

import com.devsuperior.bds04.model.dto.CityDTO;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CityService {
    List<CityDTO> findAll();
    CityDTO save(CityDTO dto);
}
