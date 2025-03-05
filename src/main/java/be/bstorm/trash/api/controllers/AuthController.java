package be.bstorm.trash.api.controllers;

import be.bstorm.trash.api.models.security.dtos.WizardTokenDTO;
import be.bstorm.trash.api.models.security.forms.LoginForm;
import be.bstorm.trash.api.models.security.forms.RegisterForm;
import be.bstorm.trash.bll.AuthService;
import be.bstorm.trash.il.utils.JwtUtil;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/auth")
public class AuthController {

    private final AuthService authService;
    private final JwtUtil jwtUtil;

    @PreAuthorize("isAnonymous()")
    @PostMapping("/register")
    public ResponseEntity<Void> register(
            @Valid @RequestPart("form") RegisterForm form
    ) {
        // INFO: Only adopters can be registered
        // as staff can only be created by admin and other staffs
        throw new UnsupportedOperationException("Not implemented yet");
    }

    @PreAuthorize("isAnonymous()")
    @PostMapping("/login")
    public ResponseEntity<WizardTokenDTO> login(
            @Valid @RequestBody LoginForm form
    ) {
        throw new UnsupportedOperationException("Not implemented yet");
    }
}

