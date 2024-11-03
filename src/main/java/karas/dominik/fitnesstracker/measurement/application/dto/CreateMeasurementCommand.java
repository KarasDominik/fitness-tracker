package karas.dominik.fitnesstracker.measurement.application.dto;

import lombok.Builder;

import java.util.UUID;

@Builder
public record CreateMeasurementCommand(UUID userId, double weight, double calf, double thigh, double hips, double waist,
                                       double belly, double chest, double arm, double forearm) {
}
