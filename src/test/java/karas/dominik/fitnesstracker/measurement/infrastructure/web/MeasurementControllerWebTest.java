package karas.dominik.fitnesstracker.measurement.infrastructure.web;

import karas.dominik.fitnesstracker.common.BaseAbstractWebTest;
import karas.dominik.fitnesstracker.common.time.TimeProvider;
import karas.dominik.fitnesstracker.common.user.LoggedUserProvider;
import karas.dominik.fitnesstracker.common.user.LoggedUserProvider.LoggedUser;
import karas.dominik.fitnesstracker.common.user.UserId;
import karas.dominik.fitnesstracker.measurement.MeasurementService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.web.servlet.MockMvc;

import java.util.stream.Stream;

import static karas.dominik.fitnesstracker.common.TestUtils.fetchJsonFrom;
import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.csrf;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(MeasurementController.class)
@WithMockUser
class MeasurementControllerWebTest extends BaseAbstractWebTest {

    private static final String PATH = "/api/v1/measurement";

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private MeasurementService service;
    @MockBean
    private LoggedUserProvider loggedUserProvider;
    @MockBean
    private TimeProvider timeProvider;

    @BeforeEach
    void setUp() {
        when(loggedUserProvider.getLoggedUser()).thenReturn(new LoggedUser(UserId.create()));
    }

    @Nested
    class CreateTests {

        private static final class INVALID_REQUESTS {
            private static final String DIR = "src/test/resources/web/requests/measurement/create/invalid";

            private static final String ARM_NULL = DIR + "/arm-null.json";
            private static final String BELLY_NULL = DIR + "/belly-null.json";
            private static final String CALF_NULL = DIR + "/calf-null.json";
            private static final String CHEST_NULL = DIR + "/chest-null.json";
            private static final String FOREARM_NULL = DIR + "/forearm-null.json";
            private static final String HIPS_NULL = DIR + "/hips-null.json";
            private static final String THIGH_NULL = DIR + "/thigh-null.json";
            private static final String WAIST_NULL = DIR + "/waist-null.json";
            private static final String WEIGHT_NULL = DIR + "/weight-null.json";

            private static final String WEIGHT_NOT_POSITIVE = DIR + "/weight-not-positive.json";
            private static final String WEIGHT_TOO_LARGE = DIR + "/weight-too-large.json";
            private static final String CALF_NOT_POSITIVE = DIR + "/calf-not-positive.json";
            private static final String CALF_TOO_LARGE = DIR + "/calf-too-large.json";
            private static final String THIGH_NOT_POSITIVE = DIR + "/thigh-not-positive.json";
            private static final String THIGH_TOO_LARGE = DIR + "/thigh-too-large.json";
            private static final String HIPS_NOT_POSITIVE = DIR + "/hips-not-positive.json";
            private static final String HIPS_TOO_LARGE = DIR + "/hips-too-large.json";
            private static final String WAIST_NOT_POSITIVE = DIR + "/waist-not-positive.json";
            private static final String WAIST_TOO_LARGE = DIR + "/waist-too-large.json";
            private static final String BELLY_NOT_POSITIVE = DIR + "/belly-not-positive.json";
            private static final String BELLY_TOO_LARGE = DIR + "/belly-too-large.json";
            private static final String CHEST_NOT_POSITIVE = DIR + "/chest-not-positive.json";
            private static final String CHEST_TOO_LARGE = DIR + "/chest-too-large.json";
            private static final String ARM_NOT_POSITIVE = DIR + "/arm-not-positive.json";
            private static final String ARM_TOO_LARGE = DIR + "/arm-too-large.json";
            private static final String FOREARM_NOT_POSITIVE = DIR + "/forearm-not-positive.json";
            private static final String FOREARM_TOO_LARGE = DIR + "/forearm-too-large.json";
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
                    Arguments.of(INVALID_REQUESTS.ARM_NULL, "Arm circumference is required"),
                    Arguments.of(INVALID_REQUESTS.BELLY_NULL, "Belly circumference is required"),
                    Arguments.of(INVALID_REQUESTS.THIGH_NULL, "Thigh circumference is required"),
                    Arguments.of(INVALID_REQUESTS.CALF_NULL, "Calf circumference is required"),
                    Arguments.of(INVALID_REQUESTS.CHEST_NULL, "Chest circumference is required"),
                    Arguments.of(INVALID_REQUESTS.FOREARM_NULL, "Forearm circumference is required"),
                    Arguments.of(INVALID_REQUESTS.HIPS_NULL, "Hips circumference is required"),
                    Arguments.of(INVALID_REQUESTS.WAIST_NULL, "Waist circumference is required"),
                    Arguments.of(INVALID_REQUESTS.WEIGHT_NULL, "Weight is required"),

                    Arguments.of(INVALID_REQUESTS.WEIGHT_NOT_POSITIVE, "Weight must be positive"),
                    Arguments.of(INVALID_REQUESTS.WEIGHT_TOO_LARGE, "Weight must be less than 1000"),
                    Arguments.of(INVALID_REQUESTS.CALF_NOT_POSITIVE, "Calf circumference must be positive"),
                    Arguments.of(INVALID_REQUESTS.CALF_TOO_LARGE, "Calf circumference must be less than 1000"),
                    Arguments.of(INVALID_REQUESTS.THIGH_NOT_POSITIVE, "Thigh circumference must be positive"),
                    Arguments.of(INVALID_REQUESTS.THIGH_TOO_LARGE, "Thigh circumference must be less than 1000"),
                    Arguments.of(INVALID_REQUESTS.HIPS_NOT_POSITIVE, "Hips circumference must be positive"),
                    Arguments.of(INVALID_REQUESTS.HIPS_TOO_LARGE, "Hips circumference must be less than 1000"),
                    Arguments.of(INVALID_REQUESTS.WAIST_NOT_POSITIVE, "Waist circumference must be positive"),
                    Arguments.of(INVALID_REQUESTS.WAIST_TOO_LARGE, "Waist circumference must be less than 1000"),
                    Arguments.of(INVALID_REQUESTS.BELLY_NOT_POSITIVE, "Belly circumference must be positive"),
                    Arguments.of(INVALID_REQUESTS.BELLY_TOO_LARGE, "Belly circumference must be less than 1000"),
                    Arguments.of(INVALID_REQUESTS.CHEST_NOT_POSITIVE, "Chest circumference must be positive"),
                    Arguments.of(INVALID_REQUESTS.CHEST_TOO_LARGE, "Chest circumference must be less than 1000"),
                    Arguments.of(INVALID_REQUESTS.ARM_NOT_POSITIVE, "Arm circumference must be positive"),
                    Arguments.of(INVALID_REQUESTS.ARM_TOO_LARGE, "Arm circumference must be less than 1000"),
                    Arguments.of(INVALID_REQUESTS.FOREARM_NOT_POSITIVE, "Forearm circumference must be positive"),
                    Arguments.of(INVALID_REQUESTS.FOREARM_TOO_LARGE, "Forearm circumference must be less than 1000")
            );
        }
    }
}
