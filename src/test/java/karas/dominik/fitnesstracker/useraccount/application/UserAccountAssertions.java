package karas.dominik.fitnesstracker.useraccount.application;

import karas.dominik.fitnesstracker.common.user.UserId;
import karas.dominik.fitnesstracker.useraccount.infrastructure.persistence.UserAccounts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

@Service
@RequiredArgsConstructor
public class UserAccountAssertions {

    private final UserAccounts userAccounts;
    private final PasswordEncoder passwordEncoder;

    public void assertUserAccountExists(UserId id, Map<String, Object> expected) {
        assertThat(userAccounts.findById(id))
                .isPresent()
                .hasValueSatisfying(userAccount -> {
                    assertThat(userAccount.email()).isEqualTo(expected.get("email"));
                    assertThat(passwordEncoder.matches(expected.get("password").toString(), userAccount.password())).isTrue();
                });
    }
}
