package karas.dominik.fitnesstracker.useraccount.infrastructure.web;

import java.util.UUID;

record CreateUserAccountResponse(UUID id) {

    static CreateUserAccountResponse of(UUID id) {
        return new CreateUserAccountResponse(id);
    }
}
