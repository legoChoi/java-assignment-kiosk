package shared.exceptions.exceptions;

import shared.exceptions.exceptionMessages.ExceptionMessages;

public class NotValidInputException extends NumberFormatException {
    public NotValidInputException() {
        super(ExceptionMessages.NOT_VALID_MENU_INPUT.getMessage());
    }
}
