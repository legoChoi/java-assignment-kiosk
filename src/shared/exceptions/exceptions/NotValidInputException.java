package shared.exceptions.exceptions;

import shared.exceptions.exceptionMessages.ExceptionMessages;

public class NotValidInputException extends NumberFormatException {
    public NotValidInputException() {
        super(ExceptionMessages.NotValidMenuInput.getMessage());
    }
}
