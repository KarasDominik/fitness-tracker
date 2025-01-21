package karas.dominik.fitnesstracker.measurement.infrastructure.persistence;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import karas.dominik.fitnesstracker.common.entity.AbstractIdEntity;
import karas.dominik.fitnesstracker.common.user.UserId;
import karas.dominik.fitnesstracker.measurement.application.dto.CreateMeasurementCommand;
import karas.dominik.fitnesstracker.measurement.application.dto.MeasurementId;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.Instant;

@Entity
@Table(name = "measurement")
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Getter
public class Measurement extends AbstractIdEntity<MeasurementId> {

    public static Measurement create(CreateMeasurementCommand command) {
        return Measurement.builder()
                .id(MeasurementId.create())
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

    private UserId userId;
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
