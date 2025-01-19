package karas.dominik.fitnesstracker.measurement.application.valueobject;

import karas.dominik.fitnesstracker.common.exception.FieldInfo;
import karas.dominik.fitnesstracker.measurement.application.dto.BodyPart;

import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.isNoGreaterThan;
import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.isPositive;
import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.notNull;

public record Circumference(double value, BodyPart bodyPart) {

    public Circumference {
        isPositive(value, new FieldInfo(String.format("%s circumference", bodyPart.asCamelCase())));
        isNoGreaterThan(value, new FieldInfo(String.format("%s circumference", bodyPart.asCamelCase())), 1000);
    }

    public static Circumference of(Double value, BodyPart bodyPart) {
        notNull(value, new FieldInfo(String.format("%s circumference", bodyPart.asCamelCase())));
        return new Circumference(value, bodyPart);
    }
}
