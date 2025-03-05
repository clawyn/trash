package be.bstorm.trash.bll.impls;

import be.bstorm.trash.bll.AuthService;
import be.bstorm.trash.dal.repositories.WizardRepository;
import be.bstorm.trash.dl.entities.Wizard;
import be.bstorm.trash.dl.enums.ShelterRole;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;

import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final WizardRepository wizardRepository;
    private final PasswordEncoder passwordEncoder;

    @Transactional
    @Override
    public void register(Wizard wizard) {
        if (wizardRepository.existsById(wizard.getId())) {
            throw new RuntimeException();
        }
        wizard.setPassword(passwordEncoder.encode(wizard.getPassword()));
        wizard.setShelterRole(ShelterRole.STAFF);
        wizardRepository.save(wizard);
    }

    @Override
    public Wizard login(Long id, String password) {
        Wizard user = wizardRepository.findById(id).orElseThrow(
                RuntimeException::new
        );
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new RuntimeException();
        }
        return user;
    }

}
