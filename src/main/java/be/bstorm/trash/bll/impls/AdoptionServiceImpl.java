package be.bstorm.trash.bll.impls;

import be.bstorm.trash.bll.AdoptionService;
import be.bstorm.trash.dal.repositories.AdoptionRepository;
import be.bstorm.trash.dl.entities.Adoption;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AdoptionServiceImpl implements AdoptionService {

    private final AdoptionRepository adoptionRepository;
    @Override
    public Adoption save(Adoption adoption) {
        if (adoptionRepository.existsById(adoption.getId())) {
            throw new RuntimeException("id already exists");
        }
        adoptionRepository.save(adoption);
        return adoption;
    }

    @Override
    public Adoption findById(Long id) {
        return adoptionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public List<Adoption> findAll() {
        return adoptionRepository.findAll();
    }

    @Override
    public void update(Long id, Adoption adoption) {
        Adoption existingAdoption = adoptionRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingAdoption.setStatus(adoption.getStatus());
        existingAdoption.setBeast(adoption.getBeast());
        existingAdoption.setWizard(adoption.getWizard());
        adoptionRepository.save(existingAdoption);

    }

    @Override
    public void deleteById(Long id) {
        if (!adoptionRepository.existsById(id)) {
            throw new RuntimeException("id not found");
        }
        adoptionRepository.deleteById(id);

    }
}
