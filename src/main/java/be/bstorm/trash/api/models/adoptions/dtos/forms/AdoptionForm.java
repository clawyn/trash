package be.bstorm.trash.api.models.adoptions.dtos.forms;


import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.entities.Beast;
import be.bstorm.trash.dl.entities.Wizard;

public record AdoptionForm(
        String adoptionStatus,
        Beast beast,
        Wizard wizard
) {
    public Adoption toAdoption() {
        return new Adoption(this.adoptionStatus, this.beast, this.wizard);
    }

}
