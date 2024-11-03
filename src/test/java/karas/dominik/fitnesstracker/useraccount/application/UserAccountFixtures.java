package karas.dominik.fitnesstracker.useraccount.application;

import karas.dominik.fitnesstracker.useraccount.application.UserAccountsForTests.UserAccountTestData;
import karas.dominik.fitnesstracker.useraccount.infrastructure.persistence.UserAccount;
import karas.dominik.fitnesstracker.useraccount.infrastructure.persistence.UserAccounts;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class UserAccountFixtures {

    private final UserAccounts userAccounts;

    public void setUp(UserAccountTestData data) {
        userAccounts.save(UserAccount.builder()
                .email(data.email().value())
                .password(data.password().value())
                .build());
    }
}
