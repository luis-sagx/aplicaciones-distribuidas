package ec.edu.espe.zonas.dtos;

import java.util.UUID;

import ec.edu.espe.zonas.entidades.enums.StatusOfPlace;
import ec.edu.espe.zonas.entidades.enums.TypeOfPlace;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaceRequestDto {
    @NotNull(message = "Zone ID is required")
    @NotBlank(message = "Zone ID cannot be blank")
    private UUID idZone;

    private String code;

    private String description;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Type of place is required")
    private TypeOfPlace type;

    @Enumerated(EnumType.STRING)
    @NotBlank(message = "Status is required")
    private StatusOfPlace status;
}
