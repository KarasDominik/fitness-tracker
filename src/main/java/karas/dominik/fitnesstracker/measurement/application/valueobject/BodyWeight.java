package karas.dominik.fitnesstracker.measurement.application.valueobject;

import karas.dominik.fitnesstracker.common.FieldInfo;

import static karas.dominik.fitnesstracker.common.FieldAssertions.isNoGreaterThan;
import static karas.dominik.fitnesstracker.common.FieldAssertions.isPositive;
import static karas.dominik.fitnesstracker.common.FieldAssertions.notNull;

public record BodyWeight(double value) {

    private static final FieldInfo BODY_WEIGHT = new FieldInfo("Weight");

    public BodyWeight {
        isPositive(value, BODY_WEIGHT);
        isNoGreaterThan(value, BODY_WEIGHT, 1000);
    }

    public static BodyWeight of(Double value) {
        notNull(value, BODY_WEIGHT);
        return new BodyWeight(value);
    }
}
