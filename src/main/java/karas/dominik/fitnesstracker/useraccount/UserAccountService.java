package karas.dominik.fitnesstracker.useraccount;

import karas.dominik.fitnesstracker.common.user.AppUserDetails;
import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;

import java.util.UUID;

public interface UserAccountService {

    AppUserDetails getBy(String email);

    UUID create(CreateUserAccountCommand command);
}
