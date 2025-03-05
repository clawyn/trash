package be.bstorm.trash.bll;



import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.ShelterRole;

import java.util.List;

public interface StaffService  {
    Wizard CreateWizard(Wizard wizard, ShelterRole role);
    Wizard findById(Long id);
    List<Wizard> findAll();
    void updateStaff(Long id, Wizard wizard, ShelterRole role);
    void deleteById(Long id);
    List<Wizard> getAllStaffs();
}
