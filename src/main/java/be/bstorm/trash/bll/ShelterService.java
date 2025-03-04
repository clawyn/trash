package be.bstorm.trash.bll;

import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.entities.Shelter;

import java.util.List;

public interface ShelterService {
    Shelter save (Shelter shelter);
    Shelter findById(Long id);
    List<Shelter> findAll();
    void update(Long id, Shelter shelter);
    void deleteById(Long id);
}
