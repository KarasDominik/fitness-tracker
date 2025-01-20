package karas.dominik.fitnesstracker.useraccount.application;

import karas.dominik.fitnesstracker.common.user.AppUserDetails;
import karas.dominik.fitnesstracker.useraccount.infrastructure.persistence.UserAccounts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
class GetUserDetailsUseCase {

    private final UserAccounts userAccounts;

    public AppUserDetails execute(String username) throws UsernameNotFoundException {
        return userAccounts.findByEmail(username)
                .map(user -> new AppUserDetails(user.id(), user.email(), user.password(), emptyList()))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User account %s not found", username)));
    }
}
