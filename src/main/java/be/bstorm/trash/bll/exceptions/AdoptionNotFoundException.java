package be.bstorm.trash.bll.exceptions;

public class AdoptionNotFoundException extends RuntimeException {
    public AdoptionNotFoundException(String message) {
        super(message);
    }
}
