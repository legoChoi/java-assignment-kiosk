package handler;

import shared.exceptions.exceptions.NotValidInputException;
import shared.io.input.Input;

public class BaseHandler {

    protected final Input consoleInputImpl;

    protected BaseHandler(Input consoleInputImpl) {
        this.consoleInputImpl = consoleInputImpl;
    }

    /**
     * 정수 입력 값 검증
     * @param min 입력 가능한 최솟값
     * @param max 입력 가능한 최댓값
     * @return 검증된 입력값
     * @throws NotValidInputException
     */
    protected int validateCommandInput(int min, int max) {
        int response = consoleInputImpl.getIntInput();

        if (response < min || response > max) {
            throw new NotValidInputException();
        }

        return response;
    }
}
