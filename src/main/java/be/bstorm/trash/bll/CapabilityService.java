package be.bstorm.trash.bll;

import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.entities.Capability;

import java.util.List;

public interface CapabilityService {
    Capability save (Capability capability);
    Capability findById(Long id);
    List<Capability> findAll();
    void update(Long id, Capability capability);
    void deleteById(Long id);
}
