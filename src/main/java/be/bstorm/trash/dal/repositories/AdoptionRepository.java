package be.bstorm.trash.dal.repositories;


import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.enums.AdoptionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AdoptionRepository extends JpaRepository<Adoption, Long> {
    Optional<Adoption> findById(Long id);
    List<Adoption> findByStatus (AdoptionStatus status);
    boolean existsById(Long id);

}
