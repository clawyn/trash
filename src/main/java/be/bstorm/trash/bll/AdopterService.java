package be.bstorm.trash.bll;


import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.AdoptionStatus;
import org.springframework.stereotype.Service;

import java.util.List;


public interface AdopterService {
    Wizard save (Wizard wizardAdopter);
    Wizard findById(Long id);
    List<Wizard> findAll();
    void updateAdopter(Long id, Wizard wizardAdopter);
    void deleteById(Long id);
    void deleteAdopter(Long id);
    List<Wizard> getAllAdopters(AdoptionStatus status, Wizard wizard);




}
