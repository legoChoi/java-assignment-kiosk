package shared.exceptions.exceptions;

import shared.exceptions.exceptionMessages.ExceptionMessages;

public class CartEmptyException extends RuntimeException {
    public CartEmptyException() {
        super(ExceptionMessages.CART_EMPTY.getMessage());
    }
}
