package ec.edu.espe.zonas.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import ec.edu.espe.zonas.dtos.ZoneRequestDto;
import ec.edu.espe.zonas.dtos.ZoneResponseDto;
import ec.edu.espe.zonas.entidades.Zone;
import ec.edu.espe.zonas.repositories.ZoneRepository;
import ec.edu.espe.zonas.service.ZoneService;
import jakarta.transaction.Transactional;

@Service
public class ZonaServiceImpl implements ZoneService {

    @Autowired
    private ZoneRepository zoneRepository;

    @Override
    @Transactional()
    public List<ZoneResponseDto> getAllZones() {
        return zoneRepository.findAll()
            .stream()
            .map(this::toResponseDto)
            .collect(Collectors.toList());
    }

    @Override
    public ZoneResponseDto createZone(ZoneRequestDto request) {

        if(zoneRepository.existsByName(request.getName())){
            throw new ResponseStatusException(HttpStatus.CONFLICT, "This name alredy exist" );
        }

        Zone objZone = new Zone();

        objZone.setName(request.getName());
        objZone.setCode(codeGenerator(request));
        objZone.setDescription(request.getDescription());
        objZone.setCapacity(request.getCapacity());
        objZone.setType(request.getType());
        objZone.setStatus(1);
        objZone.setCreatedAt(LocalDateTime.now());
        objZone.setUpdatedAt(LocalDateTime.now());

        zoneRepository.save(objZone);
        return toResponseDto(objZone);
    }

    @Override
    public ZoneResponseDto updateZone(UUID idZone, ZoneRequestDto request) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateZone'");
    }

    @Override
    public void changeStatus(UUID idZone, int status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeStatus'");
    }

    //mapeador de entidad a dto
    private ZoneResponseDto toResponseDto(Zone zone) {
        return ZoneResponseDto.builder()
                .id(zone.getId())
                .name(zone.getName())
                .code(zone.getCode())
                .description(zone.getDescription())
                .capacity(zone.getCapacity())
                .type(zone.getType())
                .places(zone.getPlaces())
                .status(zone.getStatus())
                .createdAt(zone.getCreatedAt())
                .updatedAt(zone.getUpdatedAt())
                .build();
    }   

    private String codeGenerator(ZoneRequestDto request) {
        // Ejemplo: ZON-VIP-01
        
        String typeAbbrev = request.getType().name().substring(0, Math.min(3, request.getType().name().length())).toUpperCase();
        
        long zoneCount = zoneRepository.count();
        String sequentialNumber = String.format("%02d", zoneCount + 1);
        
        String code = "ZON-" + typeAbbrev + "-" + sequentialNumber;
        
        return code;
    }
}
