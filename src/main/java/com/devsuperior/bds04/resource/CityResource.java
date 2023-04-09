package com.devsuperior.bds04.resource;

import com.devsuperior.bds04.model.dto.CityDTO;
import com.devsuperior.bds04.services.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/cities")
public class CityResource {

    @Autowired
    private CityService service;

    @GetMapping
    public ResponseEntity<List<CityDTO>> findAll(){
        List<CityDTO> result = service.findAll();
        return ResponseEntity.ok().body(result);
    }

    @PostMapping
    public ResponseEntity<CityDTO> save(
            @RequestBody @Valid CityDTO dto
    ) {
        CityDTO cityDTO = service.save(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(cityDTO);
    }
}
