package karas.dominik.fitnesstracker.useraccount;

import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;

import java.util.UUID;

public interface UserAccountService {

    UUID create(CreateUserAccountCommand command);
}
