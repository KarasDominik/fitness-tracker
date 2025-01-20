package karas.dominik.fitnesstracker.common;

import karas.dominik.fitnesstracker.common.user.AppUserDetails;
import karas.dominik.fitnesstracker.useraccount.UserAccountService;
import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.UUID;

import static java.util.Collections.emptySet;
import static karas.dominik.fitnesstracker.measurement.config.MeasurementTestConfig.TEST_USER_ID;
import static karas.dominik.fitnesstracker.measurement.config.MeasurementTestConfig.TEST_USER_PASSWORD;

public class FakeUserAccountServiceImpl implements UserAccountService {

    private final PasswordEncoder passwordEncoder;

    public FakeUserAccountServiceImpl(PasswordEncoder passwordEncoder) {
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public AppUserDetails getBy(String email) {
        return new AppUserDetails(TEST_USER_ID, email, passwordEncoder.encode(TEST_USER_PASSWORD), emptySet());
    }

    @Override
    public UUID create(CreateUserAccountCommand command) {
        return UUID.randomUUID();
    }
}
