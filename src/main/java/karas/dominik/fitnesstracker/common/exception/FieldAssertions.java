package karas.dominik.fitnesstracker.common.exception;

import io.micrometer.common.util.StringUtils;
import lombok.NoArgsConstructor;
import org.apache.commons.validator.routines.EmailValidator;

import java.util.Objects;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class FieldAssertions {

    public static void notNull(Object value, FieldInfo fieldInfo) {
        if (Objects.isNull(value)) {
            throw new InvalidFieldException(String.format("%s is required", fieldInfo.name()));
        }
    }

    public static void notBlank(String value, FieldInfo fieldInfo) {
        if (StringUtils.isBlank(value)) {
            throw new InvalidFieldException(String.format("%s is required", fieldInfo.name()));
        }
    }

    public static void maxLength(String value, int maxLength, FieldInfo fieldInfo) {
        if (value.length() > maxLength) {
            throw new InvalidFieldException(String.format("%s cannot be longer than %d characters", fieldInfo.name(), maxLength));
        }
    }

    public static void minLength(String value, int minLength, FieldInfo fieldInfo) {
        if (value.length() < minLength) {
            throw new InvalidFieldException(String.format("%s cannot be shorter than %d characters", fieldInfo.name(), minLength));
        }
    }

    public static void isValid(boolean expression, FieldInfo fieldInfo) {
        if (!expression) {
            throw new InvalidFieldException(String.format("%s is invalid", fieldInfo.name()));
        }
    }

    public static void isValid(boolean expression, String errorMessage) {
        if (!expression) {
            throw new InvalidFieldException(errorMessage);
        }
    }

    public static boolean isEmail(String value) {
        return EmailValidator.getInstance().isValid(value);
    }

    public static void isPositive(double value, FieldInfo fieldInfo) {
        if (value <= 0) {
            throw new InvalidFieldException(String.format("%s must be positive", fieldInfo.name()));
        }
    }

    public static void isNoGreaterThan(double value, FieldInfo fieldInfo, double maxValue) {
        if (value > maxValue) {
            throw new InvalidFieldException(String.format("%s must be less than %.0f", fieldInfo.name(), maxValue));
        }
    }
}
