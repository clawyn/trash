package be.bstorm.trash.dal.initializers;

import be.bstorm.trash.dal.repositories.WizardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class DataInitializer implements CommandLineRunner {

    private final WizardRepository wizardRepository;

    @Override
    public void run(String... args) throws Exception {
        saveDefaultWizards();
    }

    public void saveDefaultWizards() {
        if (wizardRepository.count() == 0) {
            // wizardRepository.saveAll(List.of());
        }
    }
}
