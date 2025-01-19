package karas.dominik.fitnesstracker.useraccount.application.dto;

import karas.dominik.fitnesstracker.common.exception.FieldInfo;
import karas.dominik.fitnesstracker.useraccount.application.valueobject.DecodedPassword;
import karas.dominik.fitnesstracker.useraccount.application.valueobject.Email;
import lombok.Builder;

import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.notNull;

@Builder
public record CreateUserAccountCommand(Email email, DecodedPassword password) {

    private static final FieldInfo EMAIL = new FieldInfo("email");
    private static final FieldInfo PASSWORD = new FieldInfo("password");

    public CreateUserAccountCommand {
        notNull(email, EMAIL);
        notNull(password, PASSWORD);
    }
}
