package karas.dominik.fitnesstracker.useraccount.infrastructure.web;

import karas.dominik.fitnesstracker.common.user.UserId;

record CreateUserAccountResponse(UserId id) {

    static CreateUserAccountResponse of(UserId id) {
        return new CreateUserAccountResponse(id);
    }
}
