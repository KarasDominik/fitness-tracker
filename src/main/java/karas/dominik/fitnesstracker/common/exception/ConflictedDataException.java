package karas.dominik.fitnesstracker.common.exception;

import lombok.Getter;

@Getter
public abstract class ConflictedDataException extends RuntimeException {

    private final String message;

    protected ConflictedDataException(String message) {
        super(message);
        this.message = message;
    }
}
