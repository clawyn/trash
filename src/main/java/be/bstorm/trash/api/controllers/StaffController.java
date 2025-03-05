package be.bstorm.trash.api.controllers;

import be.bstorm.trash.api.models.CustomPage;
import be.bstorm.trash.api.models.staffs.dtos.StaffDTO;
import be.bstorm.trash.bll.StaffService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/staff")
public class StaffController {

    private final StaffService staffService;

    @PreAuthorize("hasAnyRole('ADMIN', 'STAFF')")
    @GetMapping
    public ResponseEntity<CustomPage<StaffDTO>> getAllStaffs(
            @RequestParam(required = false, defaultValue = "1") int page,
            @RequestParam(required = false, defaultValue = "10") int size
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PreAuthorize("hasAnyRole('STAFF', 'ADMIN')")
    @PostMapping
    public ResponseEntity<StaffDTO> createStaff(
            @RequestBody StaffDTO staffDTO
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PreAuthorize("hasAnyRole('STAFF', 'ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<StaffDTO> updateStaff(
            @PathVariable Long id,
            @RequestBody StaffDTO staffDTO
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}
