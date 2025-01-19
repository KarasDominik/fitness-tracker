package karas.dominik.fitnesstracker.useraccount.application.exception;

import karas.dominik.fitnesstracker.common.exception.ConflictedDataException;
import lombok.Getter;

@Getter
public class UserAccountCreationException extends ConflictedDataException {

    public UserAccountCreationException(String message) {
        super(message);
    }
}
