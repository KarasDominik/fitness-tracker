package karas.dominik.fitnesstracker.measurement.config;

import karas.dominik.fitnesstracker.common.FakeUserAccountServiceImpl;
import karas.dominik.fitnesstracker.common.FixedTimeProvider;
import karas.dominik.fitnesstracker.common.time.TimeProvider;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

@TestConfiguration
public class MeasurementTestConfig {

    public static final UUID TEST_USER_ID = UUID.fromString("52b71e95-a21b-4401-8776-6d544b35d9e4");
    public static final String TEST_USER_EMAIL = "test@gmail.com";
    public static final String TEST_USER_PASSWORD = "password";

    @Bean
    public TimeProvider timeProvider() {
        return new FixedTimeProvider();
    }

    @Bean
    public FakeUserAccountServiceImpl userAccountService(PasswordEncoder passwordEncoder) {
        return new FakeUserAccountServiceImpl(passwordEncoder);
    }
}
