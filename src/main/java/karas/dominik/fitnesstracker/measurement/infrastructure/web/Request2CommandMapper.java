package karas.dominik.fitnesstracker.measurement.infrastructure.web;

import karas.dominik.fitnesstracker.measurement.application.dto.CreateMeasurementCommand;
import lombok.NoArgsConstructor;

import java.util.UUID;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
class Request2CommandMapper {

    static CreateMeasurementCommand asCommand(CreateMeasurementRequest request, UUID userId) {
        return CreateMeasurementCommand.builder()
                .weight(request.weight())
                .userId(userId)
                .calf(request.calf())
                .thigh(request.thigh())
                .hips(request.hips())
                .waist(request.waist())
                .belly(request.belly())
                .chest(request.chest())
                .arm(request.arm())
                .forearm(request.forearm())
                .build();
    }
}
