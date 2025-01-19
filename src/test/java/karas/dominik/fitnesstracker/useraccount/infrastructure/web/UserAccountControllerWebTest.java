package karas.dominik.fitnesstracker.useraccount.infrastructure.web;

import karas.dominik.fitnesstracker.config.BaseAbstractWebTest;
import karas.dominik.fitnesstracker.useraccount.UserAccountService;
import karas.dominik.fitnesstracker.useraccount.application.exception.UserAccountCreationException;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static karas.dominik.fitnesstracker.config.TestUtils.fetchJsonFrom;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doThrow;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserAccountController.class)
public class UserAccountControllerWebTest extends BaseAbstractWebTest {

    private static final String PATH = "/api/v1/user";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private UserAccountService service;

    @Nested
    class CreateTests {

        private static final class INVALID_REQUESTS {
            private static final String DIR = "src/test/resources/web/requests/useraccount/create/invalid";

            private static final String EMAIL_INVALID = DIR + "/email-invalid.json";
            private static final String EMAIL_NULL = DIR + "/email-null.json";
            private static final String EMAIL_BLANK = DIR + "/email-blank.json";

            private static final String PASSWORD_BLANK = DIR + "/password-blank.json";
            private static final String PASSWORD_NO_CAPITAL_LETTER = DIR + "/password-no-capital-letter.json";
            private static final String PASSWORD_NO_DIGIT = DIR + "/password-no-digit.json";
            private static final String PASSWORD_NULL = DIR + "/password-null.json";
            private static final String PASSWORD_TOO_LONG = DIR + "/password-too-long.json";
            private static final String PASSWORD_TOO_SHORT = DIR + "/password-too-short.json";
        }

        private static final class VALID_REQUESTS {
            private static final String DIR = "src/test/resources/web/requests/useraccount/create/valid";

            private static final String VALID = DIR + "/valid.json";
        }

        @ParameterizedTest
        @MethodSource("invalidRequests")
        void shouldReturn400ForInvalidRequest(String request, String errorMessage) throws Exception {

            mockMvc.perform(post(PATH)
                            .with(csrf())
                            .contentType(APPLICATION_JSON)
                            .content(fetchJsonFrom(request)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errorMessage").value(errorMessage));
        }

        private static Stream<Arguments> invalidRequests() {
            return Stream.of(
                    Arguments.of(INVALID_REQUESTS.EMAIL_INVALID, "Email is invalid"),
                    Arguments.of(INVALID_REQUESTS.EMAIL_NULL, "Email is required"),
                    Arguments.of(INVALID_REQUESTS.EMAIL_BLANK, "Email is required"),
                    Arguments.of(INVALID_REQUESTS.PASSWORD_BLANK, "Password is required"),
                    Arguments.of(INVALID_REQUESTS.PASSWORD_NO_CAPITAL_LETTER, "Password must contain uppercase letter, digit and special character"),
                    Arguments.of(INVALID_REQUESTS.PASSWORD_NO_DIGIT, "Password must contain uppercase letter, digit and special character"),
                    Arguments.of(INVALID_REQUESTS.PASSWORD_NULL, "Password is required"),
                    Arguments.of(INVALID_REQUESTS.PASSWORD_TOO_LONG, "Password cannot be longer than 30 characters"),
                    Arguments.of(INVALID_REQUESTS.PASSWORD_TOO_SHORT, "Password cannot be shorter than 8 characters")
            );
        }

        @Test
        void shouldReturn400WhenEmailAlreadyTaken() throws Exception {
            //
            doThrow(new UserAccountCreationException("Email already taken")).when(service).create(any());

            mockMvc.perform(post(PATH)
                            .with(csrf())
                            .contentType(APPLICATION_JSON)
                            .content(fetchJsonFrom(VALID_REQUESTS.VALID)))
                    .andExpect(status().isBadRequest())
                    .andExpect(jsonPath("$.errorMessage").value("Email already taken"));
        }
    }
}
