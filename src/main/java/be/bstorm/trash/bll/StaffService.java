package be.bstorm.trash.bll;



import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.ShelterRole;

import java.util.List;

public interface StaffService  {
    Wizard createStaff(Wizard wizard);
    Wizard findById(Long id);
    List<Wizard> findAll();
    void updateStaff(Long id, Wizard wizard);
    void deleteById(Long id);
    List<Wizard> getAllStaffs();
}
