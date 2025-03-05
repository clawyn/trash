package be.bstorm.trash.api.models.adopters.dtos;


import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.ShelterRole;

public record AdopterDTO(
        Long id,
        String fullName,
        ShelterRole shelterRole
) {
    public static AdopterDTO fromWizardStaff(Wizard wizard) {
        String fullName = wizard.getLastName() + " " + wizard.getFirstName();
        return new AdopterDTO(wizard.getId(), fullName, wizard.getShelterRole());
    }
}
