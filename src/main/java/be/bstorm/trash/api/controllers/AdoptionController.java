package be.bstorm.trash.api.controllers;

import be.bstorm.trash.api.models.CustomPage;
import be.bstorm.trash.api.models.adoptions.dtos.AdoptionDTO;
import be.bstorm.trash.bll.AdoptionService;

import be.bstorm.trash.bll.exceptions.AdoptionNotFoundException;
import be.bstorm.trash.dl.entities.Adoption;
import be.bstorm.trash.dl.enums.AdoptionStatus;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/adoption")
public class AdoptionController {

    private final AdoptionService adoptionService;

    @GetMapping("/pending")
    public ResponseEntity<CustomPage<AdoptionDTO>> getPendingAdoptions(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size

    ) {
        List<Adoption> pendingAdoptions = adoptionService.getPendingAdoption();
        List<AdoptionDTO> adoptionDTOs = pendingAdoptions.stream()
                .map(AdoptionDTO::fromAdoption)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new CustomPage<>(adoptionDTOs, page, size));
    }


    @GetMapping("/approved")
    public ResponseEntity<CustomPage<AdoptionDTO>> getApprovedAdoptions(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        List<Adoption> approvedAdoptions = adoptionService.getApproveAdoption();
        List<AdoptionDTO> adoptionDTOs = approvedAdoptions.stream()
                .map(AdoptionDTO::fromAdoption)
                .collect(Collectors.toList());
        return ResponseEntity.ok(new CustomPage<>(adoptionDTOs, page, size));
    }

//    @PutMapping("/approve/{id}")
//    public ResponseEntity<AdoptionDTO> approveAdoption(
//            @PathVariable Long id,
//            @RequestParam String adoptionEmail
//    ) {
//        try{
//            Adoption adoption = adoptionService.findById(id);
//            adoption.setStatus(AdoptionStatus.APPROVED);
//            return new ResponseEntity<>(AdoptionDTO.fromAdoption(adoption), HttpStatus.OK);
//        }catch (AdoptionNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//    }

    @PutMapping("/approve/{id}")
    public ResponseEntity<AdoptionDTO> approveAdoption(
            @PathVariable Long id,
            @RequestParam String adoptionEmail
    ) {
        try {
            // Appeler le service pour approuver l'adoption et envoyer l'email
            Adoption adoption = adoptionService.approveAdoption(id, adoptionEmail);

            // Retourner la réponse avec l'adoption mise à jour
            return new ResponseEntity<>(AdoptionDTO.fromAdoption(adoption), HttpStatus.OK);
        } catch (AdoptionNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    //    @PutMapping("/reject/{id}")
//    public ResponseEntity<AdoptionDTO> rejectAdoption(
//            @PathVariable Long id,
//            @RequestParam String adoptionEmail
//    ) {
//        try{
//            Adoption adoption = adoptionService.findById(id);
//            adoption.setStatus(AdoptionStatus.REJECTED);
//            return new ResponseEntity<>(AdoptionDTO.fromAdoption(adoption), HttpStatus.OK);
//        }catch (AdoptionNotFoundException e) {
//            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
//        }
//
//    }
    @PutMapping("/reject/{id}")
    public ResponseEntity<AdoptionDTO> rejectAdoption(
            @PathVariable Long id,
            @RequestParam String adoptionEmail
    ) {
        try {
            // Appeler le service pour rejeter l'adoption et envoyer l'email
            Adoption adoption = adoptionService.rejectAdoption(id, adoptionEmail);

            // Retourner la réponse avec l'adoption mise à jour
            return new ResponseEntity<>(AdoptionDTO.fromAdoption(adoption), HttpStatus.OK);
        } catch (AdoptionNotFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}
