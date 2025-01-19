package karas.dominik.fitnesstracker.common.exception;

import lombok.NoArgsConstructor;

import java.util.function.Supplier;

import static lombok.AccessLevel.PRIVATE;

@NoArgsConstructor(access = PRIVATE)
public class GeneralAssertions {

    public static void isTrue(boolean expression, Supplier<? extends RuntimeException> exception) {
        if (!expression) {
            throw exception.get();
        }
    }

    public static void isFalse(boolean expression, Supplier<? extends RuntimeException> exception) {
        if (expression) {
            throw exception.get();
        }
    }
}
