package karas.dominik.fitnesstracker.measurement.infrastructure.web;

import io.restassured.RestAssured;
import karas.dominik.fitnesstracker.common.DockerizedDbInitializer;
import karas.dominik.fitnesstracker.common.FixedTimeProvider;
import karas.dominik.fitnesstracker.measurement.application.MeasurementAssertions;
import karas.dominik.fitnesstracker.measurement.application.dto.MeasurementId;
import karas.dominik.fitnesstracker.measurement.config.MeasurementTestConfig;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;
import java.time.Instant;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static karas.dominik.fitnesstracker.common.TestUtils.fetchJsonFrom;
import static karas.dominik.fitnesstracker.common.TestUtils.parsed;
import static karas.dominik.fitnesstracker.measurement.config.MeasurementTestConfig.TEST_USER_EMAIL;
import static karas.dominik.fitnesstracker.measurement.config.MeasurementTestConfig.TEST_USER_ID;
import static karas.dominik.fitnesstracker.measurement.config.MeasurementTestConfig.TEST_USER_PASSWORD;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;

@ApplicationModuleTest(
        mode = ApplicationModuleTest.BootstrapMode.STANDALONE,
        webEnvironment = RANDOM_PORT)
@ContextConfiguration(initializers = {DockerizedDbInitializer.class})
@ComponentScan(basePackages = "karas.dominik.fitnesstracker.measurement")
@Import(MeasurementTestConfig.class)
@ActiveProfiles("test")
public class MeasurementControllerITTest {

    @LocalServerPort
    private int port;

    private static final String PATH = "/api/v1/measurement";

    @Autowired
    private MeasurementAssertions assertions;
    @Autowired
    private FixedTimeProvider timeProvider;

    @BeforeEach
    protected void setUp() {
        RestAssured.port = port;
    }

    @Nested
    class CreateTests {

        private static final class Requests {
            private static final String VALID = "src/test/resources/web/requests/measurement/create/valid/valid.json";
        }

        @Test
        void shouldCreateMeasurement() throws IOException {
            var request = fetchJsonFrom(Requests.VALID);
            timeProvider.setNow(Instant.now());

            var id =
                    given()
                            .auth().basic(TEST_USER_EMAIL, TEST_USER_PASSWORD)
                        .when()
                            .contentType(JSON)
                            .body(request)
                            .post(PATH)
                        .then()
                            .statusCode(201)
                            .extract()
                            .jsonPath().getString("id");

            var expected = parsed(request);
            expected.put("userId", TEST_USER_ID);
            expected.put("createdDate", timeProvider.now().toString());
            assertions.assertMeasurementCreated(MeasurementId.from(id), expected);
        }
    }
}
