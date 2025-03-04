package be.bstorm.trash.bll.impls;

import be.bstorm.trash.bll.BeastService;
import be.bstorm.trash.dal.repositories.BeastRepository;
import be.bstorm.trash.dl.entities.Beast;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BeastServiceImpl implements BeastService {

    private final BeastRepository  beastRepository;

    @Override
    public Beast save(Beast beast) {
        if (beastRepository.existsById(beast.getId())){
            throw  new RuntimeException("id already exists");
        }
        beastRepository.save(beast);
        return beast;
    }

    @Override
    public Beast findById(Long id) {
        return beastRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public List<Beast> findAll() {
        return beastRepository.findAll();
    }

    @Override
    public void update(Long id, Beast beast) {
        Beast existingBeast = beastRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existingBeast.setName(beast.getName());
        existingBeast.setAvailable(beast.isAvailable());
        existingBeast.setDangerLevel(beast.getDangerLevel());
        existingBeast.setAdoption(beast.getAdoption());
        beastRepository.save(existingBeast);

    }

    @Override
    public void deleteById(Long id) {
        if (!beastRepository.existsById(id)){
            throw  new RuntimeException("id not found");
        }
        beastRepository.deleteById(id);

    }
}
