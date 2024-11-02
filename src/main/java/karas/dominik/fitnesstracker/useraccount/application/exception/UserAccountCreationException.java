package karas.dominik.fitnesstracker.useraccount.application.exception;

import lombok.Getter;

@Getter
public class UserAccountCreationException extends RuntimeException {

    private static final String MESSAGE = "Email already taken";

    private final String message;

    public UserAccountCreationException() {
        this.message = MESSAGE;
    }
}
