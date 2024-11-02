package karas.dominik.fitnesstracker.useraccount.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import karas.dominik.fitnesstracker.useraccount.application.dto.CreateUserAccountCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.UUID;
import java.util.function.Function;

@Entity
@Table(name = "user_account")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UserAccount {

    @Id
    private UUID id;

    private String email;

    private String password;

    public static UserAccount create(CreateUserAccountCommand command, Function<String, String> encode) {
        return UserAccount.builder()
                .id(UUID.randomUUID())
                .email(command.email().value())
                .password(encode.apply(command.password().value()))
                .build();
    }
}
