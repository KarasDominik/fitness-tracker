package karas.dominik.fitnesstracker.useraccount.application;

import karas.dominik.fitnesstracker.common.user.AppUserDetails;
import karas.dominik.fitnesstracker.useraccount.UserAccountService;
import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
class UserAccountServiceImpl implements UserAccountService {

    private final GetUserDetailsUseCase getUserDetails;

    private final CreateUserAccountUseCase createUserAccount;

    @Override
    public AppUserDetails getBy(String email) {
        return getUserDetails.execute(email);
    }

    @Override
    public UUID create(CreateUserAccountCommand command) {
        return createUserAccount.execute(command);
    }
}
