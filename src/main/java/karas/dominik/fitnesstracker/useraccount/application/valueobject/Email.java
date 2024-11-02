package karas.dominik.fitnesstracker.useraccount.application.valueobject;

import karas.dominik.fitnesstracker.common.FieldInfo;

import static karas.dominik.fitnesstracker.common.FieldAssertions.isEmail;
import static karas.dominik.fitnesstracker.common.FieldAssertions.isValid;
import static karas.dominik.fitnesstracker.common.FieldAssertions.notBlank;

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
