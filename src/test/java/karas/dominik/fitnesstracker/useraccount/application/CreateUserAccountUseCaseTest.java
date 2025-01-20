package karas.dominik.fitnesstracker.useraccount.application;

import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;
import karas.dominik.fitnesstracker.useraccount.application.exception.UserAccountCreationException;
import karas.dominik.fitnesstracker.useraccount.application.valueobject.DecodedPassword;
import karas.dominik.fitnesstracker.useraccount.application.valueobject.Email;
import karas.dominik.fitnesstracker.useraccount.infrastructure.persistence.UserAccounts;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.then;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CreateUserAccountUseCaseTest {

    @Mock
    private UserAccounts userAccounts;

    @InjectMocks
    private CreateUserAccountUseCase testee;

    @Test
    void shouldNotCreateUserWhenEmailInUse() {
        // given
        var command = CreateUserAccountCommand.builder()
                .email(Email.of("email@gmail.com"))
                .password(DecodedPassword.of("Test123!"))
                .build();
        when(userAccounts.existsByEmail(command.email().value())).thenReturn(true);

        // when - then
        assertThatThrownBy(() -> testee.execute(command))
                .isInstanceOf(UserAccountCreationException.class)
                .hasFieldOrPropertyWithValue("message", "Email already taken");

        then(userAccounts).should(never()).save(any());
    }
}