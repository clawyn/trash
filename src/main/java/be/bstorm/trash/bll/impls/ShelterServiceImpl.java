package be.bstorm.trash.bll.impls;

import be.bstorm.trash.bll.ShelterService;
import be.bstorm.trash.bll.exceptions.ShelterNotFoundException;
import be.bstorm.trash.dal.repositories.ShelterRepository;
import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.entities.Shelter;
import jakarta.persistence.NamedQueries;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ShelterServiceImpl implements ShelterService {

    private final ShelterRepository shelterRepository;


    @Override
    public Shelter findById(Long id) {
        return shelterRepository.findById(id).orElseThrow(
                () -> new ShelterNotFoundException("Shelter with id " + id + " not found")
        );
    }

    @Override
    public List<Shelter> findAll() {
        return shelterRepository.findAll();
    }

    @Override
    public void update(Long id, Shelter shelter) {
        Shelter existingShelter = shelterRepository.findById(id).orElseThrow(
                () -> new ShelterNotFoundException("Shelter with id " + id + " not found")
        );
        existingShelter.setName(shelter.getName());
        existingShelter.setDescription(shelter.getDescription());
        shelterRepository.save(existingShelter);
    }

}
