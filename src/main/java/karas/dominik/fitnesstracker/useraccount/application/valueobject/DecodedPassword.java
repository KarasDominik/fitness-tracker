package karas.dominik.fitnesstracker.useraccount.application.valueobject;

import karas.dominik.fitnesstracker.common.exception.FieldInfo;

import java.util.Set;

import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.isValid;
import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.maxLength;
import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.minLength;
import static karas.dominik.fitnesstracker.common.exception.FieldAssertions.notBlank;

public record DecodedPassword(String value) {

    public static DecodedPassword of(String password) {
        return new DecodedPassword(password);
    }

    private static final FieldInfo PASSWORD = new FieldInfo("Password");
    private static final Set<Character> SPECIAL_CHARACTERS = Set.of('!', '@', '#', '$', '%', '&', '*', '(', ')', '\'', '+', ',', '-', '.', '/', ':', ';', '<', '=', '>', '?', '[', ']', '^', '_', '`', '{', '|', '}');

    public DecodedPassword {
        notBlank(value, PASSWORD);
        maxLength(value, 30, PASSWORD);
        minLength(value, 8, PASSWORD);
        isValid(isValidPassword(value), "Password must contain uppercase letter, digit and special character");
    }

    private boolean isValidPassword(String value) {
        return containsUppercaseLetter(value) &&
                containsDigit(value) &&
                containsSpecialCharacter(value);
    }

    private boolean containsUppercaseLetter(String value) {
        return value.codePoints()
                .anyMatch(Character::isUpperCase);
    }

    private boolean containsDigit(String value) {
        return value.codePoints()
                .anyMatch(Character::isDigit);
    }

    private boolean containsSpecialCharacter(String value) {
        return value.codePoints()
                .mapToObj(c -> (char) c)
                .anyMatch(this::isSpecialCharacter);
    }

    private boolean isSpecialCharacter(char character) {
        return SPECIAL_CHARACTERS.contains(character);
    }
}