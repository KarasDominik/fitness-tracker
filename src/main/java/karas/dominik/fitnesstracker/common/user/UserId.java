package karas.dominik.fitnesstracker.common.user;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Getter
public class UserId implements Serializable {

    private UUID value;

    public static UserId create() {
        return new UserId(UUID.randomUUID());
    }

    public static UserId from(String value) {
        return new UserId(UUID.fromString(value));
    }

    public static UserId from(UUID value) {
        return new UserId(value);
    }

    @Override
    @JsonValue
    public String toString() {
        return value.toString();
    }
}
