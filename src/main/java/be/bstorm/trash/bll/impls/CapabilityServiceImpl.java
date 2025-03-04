package be.bstorm.trash.bll.impls;

import be.bstorm.trash.bll.CapabilityService;
import be.bstorm.trash.dal.repositories.CapabilityRepository;
import be.bstorm.trash.dl.entities.Capability;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CapabilityServiceImpl implements CapabilityService {
    private final CapabilityRepository capabilityRepository;

    @Override
    public Capability save(Capability capability) {
        if (capabilityRepository.existsById(capability.getId())){
            throw new RuntimeException("id already exists");
        }
        capabilityRepository.save(capability);
        return capability;
    }

    @Override
    public Capability findById(Long id) {
        return capabilityRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
    }

    @Override
    public List<Capability> findAll() {
        return capabilityRepository.findAll();
    }

    @Override
    public void update(Long id, Capability capability) {
        Capability existigCapability = capabilityRepository.findById(id).orElseThrow(
                () -> new RuntimeException("id not found")
        );
        existigCapability.setName(capability.getName());
        capabilityRepository.save(existigCapability);

    }

    @Override
    public void deleteById(Long id) {
        if (!capabilityRepository.existsById(id)){
            throw new RuntimeException("id not found");
        }
        capabilityRepository.deleteById(id);
    }
}
