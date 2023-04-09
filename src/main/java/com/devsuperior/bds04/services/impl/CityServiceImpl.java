package com.devsuperior.bds04.services.impl;

import com.devsuperior.bds04.model.dto.CityDTO;
import com.devsuperior.bds04.model.entities.City;
import com.devsuperior.bds04.repositories.CityRepository;
import com.devsuperior.bds04.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityRepository repository;

    public List<CityDTO> findAll() {
        final List<City> lsCities = repository.findAll(Sort.by("name"));
        return lsCities.stream().map(CityDTO::new).collect(Collectors.toList());
    }

    public CityDTO save(CityDTO dto) {
        City city = mapperToEntity(dto);
        return new CityDTO(repository.save(city));
    }

    private City mapperToEntity(CityDTO dto) {
        City entity = new City();
        entity.setName(dto.getName());
        return entity;
    }
}
