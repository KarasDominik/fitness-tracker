package karas.dominik.fitnesstracker.common;

import jakarta.servlet.http.HttpServletResponse;
import karas.dominik.fitnesstracker.useraccount.application.exception.UserAccountCreationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.io.IOException;

import static org.springframework.http.HttpStatus.BAD_REQUEST;

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
        response.getWriter().write(String.format(INVALID_FIELD_MESSAGE, exception.getMessage()));
    }

    @ExceptionHandler(UserAccountCreationException.class)
    @ResponseStatus(BAD_REQUEST)
    public void handle(HttpServletResponse response, UserAccountCreationException exception) throws IOException {
        response.setContentType("application/json");
        response.getWriter().write(String.format(INVALID_FIELD_MESSAGE, exception.getMessage()));
    }
}
