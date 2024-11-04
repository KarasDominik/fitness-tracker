package karas.dominik.fitnesstracker.config;

import io.restassured.RestAssured;
import karas.dominik.fitnesstracker.useraccount.application.UserAccountFixtures;
import org.junit.jupiter.api.BeforeEach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ContextConfiguration(initializers = {DockerizedDbInitializer.class})
@ActiveProfiles("test")
public class BaseAbstractITTest {

    @Autowired
    protected UserAccountFixtures userAccounts;

    @LocalServerPort
    private int port;

    @BeforeEach
    protected void setUp() {
        RestAssured.port = port;
    }
}
