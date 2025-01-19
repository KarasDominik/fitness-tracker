package karas.dominik.fitnesstracker.useraccount.application.valueobject;

import karas.dominik.fitnesstracker.common.exception.FieldInfo;

import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.isEmail;
import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.isValid;
import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.notBlank;

public record Email(String value) {

    private static final FieldInfo EMAIL = new FieldInfo("Email");

    public Email {
        notBlank(value, EMAIL);
        isValid(isEmail(value), EMAIL);
        value = value.toLowerCase();
    }

    public static Email of(String value) {
        return new Email(value);
    }

    @Override
    public String toString() {
        return value;
    }
}
