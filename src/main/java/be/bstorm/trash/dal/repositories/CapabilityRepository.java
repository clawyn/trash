package be.bstorm.trash.dal.repositories;


import be.bstorm.trash.dl.entities.Capability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CapabilityRepository extends JpaRepository<Capability, Long> {
    Optional<Capability> findById(Long id);
    boolean existsById(Long id);
}
