package karas.dominik.fitnesstracker.measurement.infrastructure.web;

import karas.dominik.fitnesstracker.config.BaseAbstractITTest;
import karas.dominik.fitnesstracker.measurement.application.MeasurementAssertions;
import karas.dominik.fitnesstracker.useraccount.application.UserAccountsForTests.BOB;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static karas.dominik.fitnesstracker.config.TestUtils.fetchJsonFrom;

public class MeasurementControllerITTest extends BaseAbstractITTest {

    private static final String PATH = "/api/v1/measurement";

    @Autowired
    private MeasurementAssertions assertions;

    @BeforeEach
    void setUp() {
        userAccounts.setUp(BOB.DATA);
    }

    @Nested
    class CreateTests {

        private static final class Requests {
            private static final String VALID = "src/test/resources/web/requests/measurement/create/valid/valid.json";
        }

        @Test
        void shouldCreateMeasurement() throws IOException {

            var id =
                        given()
                            .auth().basic(BOB.EMAIL.value(), BOB.PASSWORD.value())
                        .when()
                            .contentType(JSON)
                            .body(fetchJsonFrom(Requests.VALID))
                            .post(PATH)
                        .then()
                            .statusCode(201)
                            .extract()
                            .jsonPath().getString("id");

            assertions.assertMeasurementCreated(UUID.fromString(id));
        }
    }
}
