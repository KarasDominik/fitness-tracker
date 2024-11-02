package karas.dominik.fitnesstracker.useraccount.infrastructure.web;

import karas.dominik.fitnesstracker.config.BaseAbstractITTest;
import karas.dominik.fitnesstracker.useraccount.application.UserAccountAssertions;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.IOException;
import java.util.UUID;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static karas.dominik.fitnesstracker.config.TestUtils.fetchJsonFrom;
import static karas.dominik.fitnesstracker.config.TestUtils.parsed;

public class UserAccountControllerITTest extends BaseAbstractITTest {

    private static final String PATH = "/api/v1/user";
    private static final String REQUESTS_MAIN_DIR = "src/test/resources/web/requests/useraccount";

    @Autowired
    private UserAccountAssertions assertions;

    @Nested
    class CreateTests {

        private static final String DIR = REQUESTS_MAIN_DIR + "/create";
        private static final String VALID = DIR + "/valid/valid.json";

        @Test
        void shouldCreateUserAccount() throws IOException {
            var response =
                    given()
                        .auth().none()
                    .when()
                            .contentType(JSON)
                            .body(fetchJsonFrom(VALID))
                        .post(PATH)
                    .then()
                        .statusCode(201)
                        .extract()
                        .jsonPath().getString("id");

            assertions.assertUserAccountExists(UUID.fromString(response), parsed(fetchJsonFrom(VALID)));
        }
    }
}
