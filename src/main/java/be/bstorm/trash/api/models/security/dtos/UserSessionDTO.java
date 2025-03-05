package be.bstorm.trash.api.models.security.dtos;


import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.ShelterRole;

public record UserSessionDTO(
        Long id,
        ShelterRole role,
        String fullName
) {

    public static UserSessionDTO fromUser(Wizard wizard) {
        String fullName = wizard.getLastName() + " " + wizard.getFirstName();
        return new UserSessionDTO(wizard.getId(),wizard.getShelterRole(),fullName);
    }
}
