package karas.dominik.fitnesstracker.common.exception;

import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.CONFLICT;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final String INVALID_FIELD_MESSAGE = """
            {
                "errorMessage": "%s"
            }
            """;

    @ExceptionHandler(InvalidFieldException.class)
    @ResponseStatus(BAD_REQUEST)
    public void handle(HttpServletResponse response, InvalidFieldException exception) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write(String.format(INVALID_FIELD_MESSAGE, exception.message()));
    }

    @ExceptionHandler(ConflictedDataException.class)
    @ResponseStatus(CONFLICT)
    public void handle(HttpServletResponse response, ConflictedDataException exception) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write(String.format(INVALID_FIELD_MESSAGE, exception.message()));
    }
}
