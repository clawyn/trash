package be.bstorm.trash.api.models.security.dtos;

public record WizardTokenDTO(
        UserSessionDTO user,
        String token
) {
}
