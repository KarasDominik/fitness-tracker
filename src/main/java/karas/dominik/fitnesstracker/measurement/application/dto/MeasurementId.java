package karas.dominik.fitnesstracker.measurement.application.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.UUID;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MeasurementId implements Serializable {

    private UUID value;

    public static MeasurementId create() {
        return new MeasurementId(UUID.randomUUID());
    }

    public static MeasurementId from(String value) {
        return new MeasurementId(UUID.fromString(value));
    }

    public static MeasurementId from(UUID value) {
        return new MeasurementId(value);
    }

    @Override
    @JsonValue
    public String toString() {
        return value.toString();
    }
}
