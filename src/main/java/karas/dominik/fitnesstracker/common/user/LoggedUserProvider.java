package karas.dominik.fitnesstracker.common.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
public class LoggedUserProvider {

    public LoggedUser getLoggedUser() {
        return Optional.ofNullable(getAuthentication())
                .map(Authentication::getPrincipal)
                .map(principal -> (AppUserDetails) principal)
                .map(userDetails -> new LoggedUser(userDetails.id()))
                .orElseThrow(() -> {
                    log.error("Error while getting logged user");
                    return new RuntimeException("Error while getting logged user");
                });
    }

    private Authentication getAuthentication() {
        return SecurityContextHolder.getContext().getAuthentication();
    }

    public record LoggedUser(UserId id) {}
}
