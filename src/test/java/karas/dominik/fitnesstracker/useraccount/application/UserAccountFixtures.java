package karas.dominik.fitnesstracker.useraccount.application;

import karas.dominik.fitnesstracker.useraccount.application.UserAccountsForTests.UserAccountTestData;
import karas.dominik.fitnesstracker.useraccount.infrastructure.persistence.UserAccount;
import karas.dominik.fitnesstracker.useraccount.infrastructure.persistence.UserAccounts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAccountFixtures {

    private final UserAccounts userAccounts;
    private final PasswordEncoder passwordEncoder;

    public void setUp(UserAccountTestData data) {
        userAccounts.save(UserAccount.builder()
                .id(data.userId())
                .email(data.email().value())
                .password(passwordEncoder.encode(data.password().value()))
                .build());
    }
}
