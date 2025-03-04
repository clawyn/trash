package be.bstorm.trash.bll;

import be.bstorm.trash.dl.entities.Adoption;

import java.util.List;

public interface AdoptionService {
    Adoption save (Adoption adoption);
    Adoption findById(Long id);
    List<Adoption> findAll();
    void update(Long id, Adoption adoption);
    void deleteById(Long id);
}
