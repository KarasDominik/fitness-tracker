package karas.dominik.fitnesstracker.useraccount.application;

import karas.dominik.fitnesstracker.common.user.AppUserDetails;
import karas.dominik.fitnesstracker.useraccount.UserAccountService;
import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
class UserAccountServiceImpl implements UserAccountService, UserDetailsService {

    private final CreateUserAccountUseCase createUserAccount;
    private final LoadUserByUsernameUseCase loadUserByUsername;

    @Override
    public UUID create(CreateUserAccountCommand command) {
        return createUserAccount.execute(command);
    }

    @Override
    public AppUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return loadUserByUsername.execute(username);
    }
}
