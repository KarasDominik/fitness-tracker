package karas.dominik.fitnesstracker.measurement.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import karas.dominik.fitnesstracker.measurement.application.dto.CreateMeasurementCommand;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
                .weight(command.weight())
                .calf(command.calf())
                .thigh(command.thigh())
                .hips(command.hips())
                .waist(command.waist())
                .belly(command.belly())
                .chest(command.chest())
                .arm(command.arm())
                .forearm(command.forearm())
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
}
