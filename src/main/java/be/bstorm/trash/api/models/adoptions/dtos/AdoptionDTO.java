package be.bstorm.trash.api.models.adoptions.dtos;


import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.enums.AdoptionStatus;

public record AdoptionDTO(
        Long id,
        AdoptionStatus adoptionStatus
) {
    public static AdoptionDTO fromAdoption(Adoption adoption){
        return new AdoptionDTO(adoption.getId(), adoption.getStatus());
    }
}
