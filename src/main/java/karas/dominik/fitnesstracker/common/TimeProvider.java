package karas.dominik.fitnesstracker.common;

import java.time.Instant;

public interface TimeProvider {

    Instant now();
}
