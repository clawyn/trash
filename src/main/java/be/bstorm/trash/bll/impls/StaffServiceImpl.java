package be.bstorm.trash.bll.impls;


import be.bstorm.trash.bll.StaffService;
import be.bstorm.trash.dal.repositories.WizardRepository;
import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.ShelterRole;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class StaffServiceImpl implements StaffService {
    private WizardRepository wizardRepository;

    @Override
    public Wizard CreateWizard(Wizard wizard, ShelterRole role) {
        if (wizardRepository.existsById(wizard.getId())) {
            if (role == wizard.getShelterRole()) {
                wizard.setShelterRole(role);
            }
        }
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
    public void updateStaff(Long id, Wizard wizard, ShelterRole role) {

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
