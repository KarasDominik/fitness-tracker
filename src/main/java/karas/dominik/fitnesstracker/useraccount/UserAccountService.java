package karas.dominik.fitnesstracker.useraccount;

import karas.dominik.fitnesstracker.common.user.AppUserDetails;
import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;
import karas.dominik.fitnesstracker.common.user.UserId;

public interface UserAccountService {

    AppUserDetails getBy(String email);

    UserId create(CreateUserAccountCommand command);
}
