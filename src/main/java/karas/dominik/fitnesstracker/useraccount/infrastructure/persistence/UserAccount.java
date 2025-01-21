package karas.dominik.fitnesstracker.useraccount.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import karas.dominik.fitnesstracker.common.entity.AbstractIdEntity;
import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;
import karas.dominik.fitnesstracker.common.user.UserId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.util.function.Function;

@Entity
@Table(name = "user_account")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserAccount extends AbstractIdEntity<UserId> {

    private String email;

    private String password;

    public static UserAccount create(CreateUserAccountCommand command, Function<String, String> encode) {
        return UserAccount.builder()
                .id(UserId.create())
                .email(command.email().value())
                .password(encode.apply(command.password().value()))
                .build();
    }
}
