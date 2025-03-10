package be.bstorm.trash.bll.impls;

import be.bstorm.trash.bll.AdopterService;
import be.bstorm.trash.dal.repositories.WizardRepository;
import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.AdoptionStatus;
import lombok.RequiredArgsConstructor;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AdopterServiceImpl implements AdopterService {
    private final WizardRepository wizardRepository;

    @Override
    public Wizard save(Wizard wizardAdopter) {
        if (wizardRepository.existsById(wizardAdopter.getId())) {
            throw new RuntimeException("id already exists");
        }
        wizardRepository.save(wizardAdopter);
        return wizardAdopter;
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
    public void updateAdopter(Long id, Wizard wizardAdopter) {
        Wizard existingWizardAdopter = wizardRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingWizardAdopter.setFirstName(wizardAdopter.getFirstName());
        existingWizardAdopter.setLastName(wizardAdopter.getLastName());
        existingWizardAdopter.setEmail(wizardAdopter.getEmail());
        existingWizardAdopter.setPassword(wizardAdopter.getPassword());
        existingWizardAdopter.setShelterRole(wizardAdopter.getShelterRole());
        existingWizardAdopter.setWizardHouse(wizardAdopter.getWizardHouse());
        existingWizardAdopter.setAdoptions(wizardAdopter.getAdoptions());
        wizardRepository.save(existingWizardAdopter);
    }

    @Override
    public void deleteById(Long id) {
        if (!wizardRepository.existsById(id)) {
            throw new RuntimeException("id not found");
        }
        wizardRepository.deleteById(id);

    }

    @Override
    public void deleteAdopter(Long id) {
        if (!wizardRepository.existsById(id)) {
            throw new RuntimeException("id not found");
        }
        wizardRepository.deleteById(id);
    }

    @Override
    public List<Wizard> getAllAdopters(AdoptionStatus status, Wizard wizard) {
            List<Wizard> adopters = new ArrayList<>();

            return null;
    }
}
