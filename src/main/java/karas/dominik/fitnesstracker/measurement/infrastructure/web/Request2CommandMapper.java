package karas.dominik.fitnesstracker.measurement.infrastructure.web;

import karas.dominik.fitnesstracker.common.user.UserId;
import karas.dominik.fitnesstracker.measurement.application.dto.CreateMeasurementCommand;
import karas.dominik.fitnesstracker.measurement.application.valueobject.BodyWeight;
import karas.dominik.fitnesstracker.measurement.application.valueobject.Circumference;
import lombok.NoArgsConstructor;

import java.time.Instant;
import java.util.function.Supplier;

import static karas.dominik.fitnesstracker.measurement.application.dto.BodyPart.ARM;
import static karas.dominik.fitnesstracker.measurement.application.dto.BodyPart.BELLY;
import static karas.dominik.fitnesstracker.measurement.application.dto.BodyPart.CALF;
import static karas.dominik.fitnesstracker.measurement.application.dto.BodyPart.CHEST;
import static karas.dominik.fitnesstracker.measurement.application.dto.BodyPart.FOREARM;
import static karas.dominik.fitnesstracker.measurement.application.dto.BodyPart.HIPS;
import static karas.dominik.fitnesstracker.measurement.application.dto.BodyPart.THIGH;
import static karas.dominik.fitnesstracker.measurement.application.dto.BodyPart.WAIST;
import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
class Request2CommandMapper {

    static CreateMeasurementCommand asCommand(CreateMeasurementRequest request, UserId userId, Supplier<Instant> now) {
        return CreateMeasurementCommand.builder()
                .weight(BodyWeight.of(request.weight()))
                .userId(userId)
                .calf(Circumference.of(request.calf(), CALF))
                .thigh(Circumference.of(request.thigh(), THIGH))
                .hips(Circumference.of(request.hips(), HIPS))
                .waist(Circumference.of(request.waist(), WAIST))
                .belly(Circumference.of(request.belly(), BELLY))
                .chest(Circumference.of(request.chest(), CHEST))
                .arm(Circumference.of(request.arm(), ARM))
                .forearm(Circumference.of(request.forearm(), FOREARM))
                .date(now.get())
                .build();
    }
}
