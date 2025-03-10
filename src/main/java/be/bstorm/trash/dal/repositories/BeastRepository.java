package be.bstorm.trash.dal.repositories;


import be.bstorm.trash.dl.entities.Beast;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BeastRepository extends JpaRepository<Beast, Long> {
    Optional<Beast> findById(Long id);
    boolean existsById(Long id);
}
