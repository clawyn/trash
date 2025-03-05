package be.bstorm.trash.api.models.adoptions.dtos;


import be.bstorm.trash.api.models.beasts.dtos.BeastDTO;
import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.enums.AdoptionStatus;

public record AdoptionDTO(
        Long id,
        AdoptionStatus adoptionStatus,
        BeastDTO beastDTO
) {
    public static AdoptionDTO fromAdoption(Adoption adoption){
        BeastDTO beastDTO = BeastDTO.fromBeast(adoption.getBeast());
        return new AdoptionDTO(adoption.getId(), adoption.getStatus(), beastDTO);
    }
}