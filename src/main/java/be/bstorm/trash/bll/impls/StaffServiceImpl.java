package be.bstorm.trash.bll.impls;


import be.bstorm.trash.bll.StaffService;
import be.bstorm.trash.dal.repositories.WizardRepository;
import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.ShelterRole;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StaffServiceImpl implements StaffService {
    private WizardRepository wizardRepository;

    @Autowired
    public StaffServiceImpl(WizardRepository wizardRepository) {
        this.wizardRepository = wizardRepository;
    }
    @Override
    public Wizard createStaff(Wizard wizard) {
        wizard.setShelterRole(ShelterRole.STAFF);
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
    public void updateStaff(Long id, Wizard wizard) {
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
        if (!wizardRepository.existsById(id)) {
            throw new RuntimeException("id not found");
        }
        wizardRepository.deleteById(id);
    }

    @Override
    public List<Wizard> getAllStaffs() {
        return wizardRepository.findAll();
    }
}