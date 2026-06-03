package ec.edu.espe.zonas.repositories;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.edu.espe.zonas.entidades.Place;
import ec.edu.espe.zonas.entidades.Zone;

public interface PlaceRepository extends JpaRepository<Place, UUID>{
    boolean existsByCode(String code);

    List<Place> findByZone(Zone zone);

    List<Place> findByZoneAndStatus(Zone zone, boolean status);

    List<Place> findByStatus(boolean status);
    
}
