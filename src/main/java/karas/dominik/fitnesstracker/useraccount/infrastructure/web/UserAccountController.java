package karas.dominik.fitnesstracker.useraccount.infrastructure.web;

import karas.dominik.fitnesstracker.useraccount.UserAccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static karas.dominik.fitnesstracker.useraccount.infrastructure.web.Request2CommandMapper.asCommand;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/user")
class UserAccountController {

    private final UserAccountService service;

    @PostMapping
    @ResponseStatus(CREATED)
    CreateUserAccountResponse create(@RequestBody CreateUserRequest request) {
        return CreateUserAccountResponse.of(service.create(asCommand(request)));
    }
}
