package karas.dominik.fitnesstracker.useraccount.infrastructure.security;

import karas.dominik.fitnesstracker.useraccount.infrastructure.persistence.UserAccounts;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import static java.util.Collections.emptyList;

@Service
@RequiredArgsConstructor
public class AppUserDetailsService implements UserDetailsService {

    private final UserAccounts userAccounts;

    @Override
    public AppUserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userAccounts.findByEmail(username)
                .map(user -> new AppUserDetails(user.id(), user.email(), user.password(), emptyList()))
                .orElseThrow(() -> new UsernameNotFoundException(String.format("User account %s not found", username)));
    }
}
