package be.bstorm.trash.api.models.staffs.dtos.dtos;


import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.ShelterRole;
import be.bstorm.trash.dl.enums.WizardHouse;

public record StaffDTO(
        Long id,
        String fullName,
        ShelterRole shelterRole,
        WizardHouse wizardHouse
) {
    public static StaffDTO fromWizardStaff(Wizard wizard) {
        String fullName = wizard.getLastName() + " " + wizard.getFirstName();
        return new StaffDTO(wizard.getId(), fullName, wizard.getShelterRole(), wizard.getWizardHouse());
    }
}
