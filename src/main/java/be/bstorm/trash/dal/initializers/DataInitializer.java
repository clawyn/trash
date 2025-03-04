package be.bstorm.trash.dal.initializers;

import be.bstorm.trash.dal.repositories.AdoptionRepository;
import be.bstorm.trash.dal.repositories.BeastRepository;
import be.bstorm.trash.dal.repositories.CapabilityRepository;
import be.bstorm.trash.dal.repositories.WizardRepository;
import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.entities.Beast;
import be.bstorm.trash.dl.entities.Capability;
import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.AdoptionStatus;
import be.bstorm.trash.dl.enums.DangerLevel;
import be.bstorm.trash.dl.enums.ShelterRole;
import be.bstorm.trash.dl.enums.WizardHouse;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final WizardRepository wizardRepository;
    private final BeastRepository beastRepository;
    private final CapabilityRepository capabilityRepository;
    private final AdoptionRepository adoptionRepository;

    @Override
    public void run(String... args) throws Exception {
        saveDefaultWizards();
        saveDefaultBeasts();
    }

    public void saveDefaultWizards() {
        if (wizardRepository.count() == 0) {
            Wizard wizard = new Wizard("albus wilfred percival brian", "Dumbledore", "dumby@gmail.mag", ShelterRole.ADMIN, WizardHouse.GRYFFINDOR);
            wizardRepository.save(wizard);
        }
    }

    public void saveDefaultBeasts(){
        if (beastRepository.count() == 0){
            //Capability
            Set<Capability> capabilities = Set.of(
                    new Capability("fire"),
                    new Capability("frozen"),
                    new Capability("flight"),
                    new Capability("small"),
                    new Capability("big"));
            capabilityRepository.saveAll(capabilities);

            //Adoption
            Adoption adoption = new Adoption(AdoptionStatus.PENDING);
            adoption = adoptionRepository.save(adoption);

            //Beast
            List<Beast> beasts = List.of(
                    new Beast("Smaug", true, DangerLevel.INSANE,adoption,capabilities ),
                    new Beast("Phoenix des Glace", true, DangerLevel.HIGH, adoption, capabilities),
                    new Beast("Dylan", true, DangerLevel.LOW, adoption, capabilities),
                    new Beast("Croutard",true,DangerLevel.MEDIUM, adoption, capabilities)
            );
            beastRepository.saveAll(beasts);
        }
    }
}
