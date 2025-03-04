package be.bstorm.trash.bll.impls;

import be.bstorm.trash.bll.ShelterService;
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
    public Shelter save (Shelter shelter) {
        if (shelterRepository.existsById(shelter.getId())){
            throw new RuntimeException("id already exists");
        }
        shelterRepository.save(shelter);
        return shelter;
    }

    @Override
    public Shelter findById(Long id) {
        return shelterRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public List<Shelter> findAll() {
        return shelterRepository.findAll();
    }

    @Override
    public void update(Long id, Shelter shelter) {
        Shelter existingShelter = shelterRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingShelter.setName(shelter.getName());
        existingShelter.setDescription(shelter.getDescription());
        shelterRepository.save(existingShelter);
    }

    @Override
    public void deleteById(Long id) {
        if (!shelterRepository.existsById(id)){
            throw new RuntimeException("id not found");
        }
        shelterRepository.deleteById(id);

    }
}
