package be.bstorm.trash.bll;

import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.entities.Beast;

import java.util.List;

public interface BeastService {
    Beast save (Beast beast);
    Beast findById(Long id);
    List<Beast> findAll();
    void update(Long id, Beast beast);
    void deleteById(Long id);

}
