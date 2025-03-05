package be.bstorm.trash.api.models.security.forms;


import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.WizardHouse;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;


import java.time.LocalDate;

public record RegisterForm(
        @NotBlank @Size(max = 150)
        String email,
        @NotBlank
        String password,
        @NotBlank @Size(max = 123)
        String firstName,
        @NotBlank @Size(max = 80)
        String lastName,
        @NotBlank
        WizardHouse wizardHouse
) {

    public Wizard toWizard() {
        return new Wizard(
                this.firstName,
                this.lastName,
                this.email,
                this.wizardHouse,
                this.password



        );
    }
}
