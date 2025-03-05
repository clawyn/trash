package be.bstorm.trash.api.models.staffs.dtos.dtos;


import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.WizardHouse;

public record StaffForm(
       String  firstName,
       String  lastName,
       String email,
       String password,
       WizardHouse wizardHouse

) {
    public Wizard toWizard  () {

        return new Wizard(this.firstName,this.lastName, this.email, this.password, this.wizardHouse);
    }
}
