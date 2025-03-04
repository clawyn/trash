package be.bstorm.trash.bll.impls;

import be.bstorm.trash.bll.WizardService;
import be.bstorm.trash.dal.repositories.WizardRepository;
import be.bstorm.trash.dl.entities.Wizard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WizardServiceImpl implements WizardService {

    private final WizardRepository wizardRepository;

    @Override
    public Wizard save(Wizard wizard) {
        if (wizardRepository.existsById(wizard.getId())){
            throw new RuntimeException("id already exists");
        }
        wizardRepository.save(wizard);
        return wizard;
    }

    @Override
    public Wizard findById(Long id) {
        return wizardRepository.findById(id).orElseThrow(
            () -> new RuntimeException("id not found")
        );
    }

    @Override
    public List<Wizard> findAll() {
        return wizardRepository.findAll();
    }

    @Override
    public void update(Long id, Wizard wizard) {
        Wizard existingWizard = wizardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingWizard.setFirstName(wizard.getFirstName());
        existingWizard.setLastName(wizard.getLastName());
        existingWizard.setPassword(wizard.getPassword());
        existingWizard.setEmail(wizard.getEmail());
        existingWizard.setShelterRole(wizard.getShelterRole());
        existingWizard.setAdoptions(wizard.getAdoptions());
        existingWizard.setWizardHouse(wizard.getWizardHouse());
        wizardRepository.save(existingWizard);
    }

    @Override
    public void deleteById(Long id) {
        if (!wizardRepository.existsById(id)){
            throw new RuntimeException("id not found");
        }
        wizardRepository.deleteById(id);

    }
}
