package karas.dominik.fitnesstracker.measurement.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import karas.dominik.fitnesstracker.measurement.application.dto.CreateMeasurementCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.UUID;

@Entity
@Table(name = "measurement")
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Measurement {

    public static Measurement create(CreateMeasurementCommand command) {
        return Measurement.builder()
                .id(UUID.randomUUID())
                .userId(command.userId())
                .weight(command.weight().value())
                .calf(command.calf().value())
                .thigh(command.thigh().value())
                .hips(command.hips().value())
                .waist(command.waist().value())
                .belly(command.belly().value())
                .chest(command.chest().value())
                .arm(command.arm().value())
                .forearm(command.forearm().value())
                .date(command.date())
                .build();
    }

    @Id
    private UUID id;
    private UUID userId;
    private double weight;
    private double calf;
    private double thigh;
    private double hips;
    private double waist;
    private double belly;
    private double chest;
    private double arm;
    private double forearm;
    private Instant date;
}
