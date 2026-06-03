package ec.edu.espe.zonas.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import ec.edu.espe.zonas.dtos.ZoneRequestDto;
import ec.edu.espe.zonas.dtos.ZoneResponseDto;
import ec.edu.espe.zonas.service.ZoneService;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/zones")
@Validated
public class ZoneController {

    @Autowired
    private ZoneService zoneService;

    @GetMapping
    public List<ZoneResponseDto> getAllZones() {
        return zoneService.getAllZones();
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ZoneResponseDto createZone(@Valid @RequestBody ZoneRequestDto request) {
        return zoneService.createZone(request);
    }
}
