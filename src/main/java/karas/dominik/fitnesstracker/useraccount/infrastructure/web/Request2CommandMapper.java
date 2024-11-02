package karas.dominik.fitnesstracker.useraccount.infrastructure.web;

import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;
import karas.dominik.fitnesstracker.useraccount.application.valueobject.DecodedPassword;
import karas.dominik.fitnesstracker.useraccount.application.valueobject.Email;
import lombok.NoArgsConstructor;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
class Request2CommandMapper {

    static CreateUserAccountCommand asCommand(CreateUserRequest request) {
        return CreateUserAccountCommand.builder()
            .email(Email.of(request.email()))
            .password(DecodedPassword.of(request.password()))
            .build();
    }
}
