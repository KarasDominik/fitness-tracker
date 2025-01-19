package karas.dominik.fitnesstracker.measurement.application.dto;

import karas.dominik.fitnesstracker.common.exception.FieldInfo;
import karas.dominik.fitnesstracker.measurement.application.valueobject.BodyWeight;
import karas.dominik.fitnesstracker.measurement.application.valueobject.Circumference;
import lombok.Builder;

import java.time.Instant;
import java.util.UUID;

import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.notNull;

@Builder
public record CreateMeasurementCommand(UUID userId, BodyWeight weight, Circumference calf, Circumference thigh,
                                       Circumference hips, Circumference waist, Circumference belly,
                                       Circumference chest, Circumference arm, Circumference forearm,
                                       Instant date) {

    private static final class FieldInfos {
        private static final FieldInfo USER_ID = new FieldInfo("UserId");
        private static final FieldInfo WEIGHT = new FieldInfo("Weight");
        private static final FieldInfo CALF = new FieldInfo("Calf measurement");
        private static final FieldInfo THIGH = new FieldInfo("Thigh measurement");
        private static final FieldInfo HIPS = new FieldInfo("Hips measurement");
        private static final FieldInfo WAIST = new FieldInfo("Waist measurement");
        private static final FieldInfo BELLY = new FieldInfo("Belly measurement");
        private static final FieldInfo CHEST = new FieldInfo("Chest measurement");
        private static final FieldInfo ARM = new FieldInfo("Arm measurement");
        private static final FieldInfo FOREARM = new FieldInfo("Forearm measurement");
        private static final FieldInfo DATE = new FieldInfo("Date");
    }

    public CreateMeasurementCommand {
        notNull(userId, FieldInfos.USER_ID);
        notNull(weight, FieldInfos.WEIGHT);
        notNull(calf, FieldInfos.CALF);
        notNull(thigh, FieldInfos.THIGH);
        notNull(hips, FieldInfos.HIPS);
        notNull(waist, FieldInfos.WAIST);
        notNull(belly, FieldInfos.BELLY);
        notNull(chest, FieldInfos.CHEST);
        notNull(arm, FieldInfos.ARM);
        notNull(forearm, FieldInfos.FOREARM);
        notNull(date, FieldInfos.DATE);
    }
}
