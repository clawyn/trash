package be.bstorm.trash.api.models.wizards.dtos;


import be.bstorm.trash.dl.entities.Wizard;

public record WizardDTO(
        Long id,
        String fullName
) {
    public static WizardDTO fromWizard(Wizard wizard) {
        String fullName = wizard.getLastName() + " " + wizard.getFirstName();
        return new WizardDTO(wizard.getId(), fullName);
    }
}
