package karas.dominik.fitnesstracker.useraccount.infrastructure.web;

import io.restassured.RestAssured;
import karas.dominik.fitnesstracker.common.DockerizedDbInitializer;
import karas.dominik.fitnesstracker.common.user.UserId;
import karas.dominik.fitnesstracker.useraccount.application.UserAccountAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.modulith.test.ApplicationModuleTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

import java.io.IOException;

import static io.restassured.RestAssured.given;
import static io.restassured.http.ContentType.JSON;
import static karas.dominik.fitnesstracker.common.TestUtils.fetchJsonFrom;
import static karas.dominik.fitnesstracker.common.TestUtils.parsed;
import static org.springframework.boot.test.context.SpringBootTest.WebEnvironment.RANDOM_PORT;
import static org.springframework.modulith.test.ApplicationModuleTest.BootstrapMode.STANDALONE;

@ApplicationModuleTest(
        mode = STANDALONE,
        webEnvironment = RANDOM_PORT)
@ContextConfiguration(initializers = {DockerizedDbInitializer.class})
@ComponentScan(basePackages = "karas.dominik.fitnesstracker.useraccount")
@ActiveProfiles("test")
public class UserAccountControllerITTest {

    @LocalServerPort
    private int port;

    private static final String PATH = "/api/v1/user";
    private static final String REQUESTS_MAIN_DIR = "src/test/resources/web/requests/useraccount";

    @Autowired
    private UserAccountAssertions assertions;

    @BeforeEach
    protected void setUp() {
        RestAssured.port = port;
    }

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
                            .log().all()
                            .statusCode(201)
                            .extract()
                            .jsonPath().getString("id");

            assertions.assertUserAccountExists(UserId.from(response), parsed(fetchJsonFrom(VALID)));
        }
    }
}
