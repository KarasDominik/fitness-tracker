package karas.dominik.fitnesstracker.measurement.application.valueobject;

import karas.dominik.fitnesstracker.common.exception.FieldInfo;

import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.isNoGreaterThan;
import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.isPositive;
import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.notNull;

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
