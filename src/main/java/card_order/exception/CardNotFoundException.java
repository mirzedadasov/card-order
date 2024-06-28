package card_order.exception;

import org.springframework.validation.Errors;

public class CardNotFoundException extends RuntimeException {
    public CardNotFoundException(String message) {
        super(message);
    }

    public Errors getBindingResult() {
        return null;
    }
}
