package be.bstorm.trash.bll;

import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.entities.Wizard;

import java.util.List;

public interface WizardService {
    Wizard save (Wizard wizard);
    Wizard findById(Long id);
    List<Wizard> findAll();
    void update(Long id, Wizard wizard);
    void deleteById(Long id);
}
