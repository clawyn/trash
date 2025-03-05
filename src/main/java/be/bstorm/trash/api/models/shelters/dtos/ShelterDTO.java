package be.bstorm.trash.api.models.shelters.dtos;


import be.bstorm.trash.dl.entities.Shelter;

public record ShelterDTO(
        Long id,
        String name,
        String description
) {
    public static ShelterDTO fromShelter(Shelter shelter){
        return new ShelterDTO(shelter.getId(), shelter.getName(), shelter.getDescription());
    }
}
