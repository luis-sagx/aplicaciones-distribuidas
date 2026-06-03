package ec.edu.espe.zonas.service.impl;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ec.edu.espe.zonas.dtos.PlaceRequestDto;
import ec.edu.espe.zonas.dtos.PlaceResponseDto;
import ec.edu.espe.zonas.entidades.Place;
import ec.edu.espe.zonas.entidades.Zone;
import ec.edu.espe.zonas.entidades.enums.StatusOfPlace;
import ec.edu.espe.zonas.repositories.PlaceRepository;
import ec.edu.espe.zonas.repositories.ZoneRepository;
import ec.edu.espe.zonas.service.PlaceService;
import ec.edu.espe.zonas.utils.UtilsMappers;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PlaceServiceImpl implements PlaceService {
    private final PlaceRepository placeRepository;
    private final ZoneRepository zoneRepository;
    private final UtilsMappers mappers;

    @Override
    @Transactional(readOnly = true)
    public List<PlaceResponseDto> getAllPlaces() {
        return placeRepository.findAll()
            .stream()
            .map(mappers::toPlaceResponseDto)
            .toList();
    }

    @Override
    @Transactional()
    public PlaceResponseDto createPlace(PlaceRequestDto request) {
        Zone objZona = zoneRepository.findById(request.getIdZone())
            .orElseThrow(() -> new RuntimeException("Zone not found"));

        Place newPlace = mappers.toEntityPlace(request);
        newPlace.setZone(objZona);
        newPlace.setStatus(StatusOfPlace.AVAILABLE);

        Place savedPlace = placeRepository.save(newPlace);

        return mappers.toPlaceResponseDto(savedPlace);  
    }

    @Override
    @Transactional
    public PlaceResponseDto updatePlace(PlaceRequestDto request, UUID id) {
        Place existing = placeRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Place not found"));

        String newCode = request.getCode();
        if (newCode != null && !newCode.equals(existing.getCode())) {
            if (placeRepository.existsByCode(newCode)) {
                throw new RuntimeException("Place code already in use");
            }
            existing.setCode(newCode);
        }

        if (request.getDescription() != null) {
            existing.setDescription(request.getDescription());
        }

        if (request.getType() != null) {
            existing.setType(request.getType());
        }

        if (request.getStatus() != null) {
            existing.setStatus(request.getStatus());
        }

        if (request.getIdZone() != null && (!request.getIdZone().equals(existing.getZone().getId()))) {
            Zone newZone = zoneRepository.findById(request.getIdZone())
                .orElseThrow(() -> new RuntimeException("Zone not found"));
            existing.setZone(newZone);
        }

        existing.setUpdatedAt(LocalDateTime.now());

        Place saved = placeRepository.save(existing);
        return mappers.toPlaceResponseDto(saved);
    }

    @Override
    public void deletePlaceById(String id) {
        
        throw new UnsupportedOperationException("Unimplemented method 'deletePlaceById'");
    }

    @Override
    public PlaceResponseDto changeStatus(StatusOfPlace status, UUID id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'changeStatus'");
    }

    @Override
    public List<PlaceResponseDto> getPlacesByStatus(StatusOfPlace status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlacesByStatus'");
    }

    @Override
    public List<PlaceResponseDto> getPlacesByZoneAndStatus(UUID idZona, StatusOfPlace status) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getPlacesByZoneAndStatus'");
    }
    
}
