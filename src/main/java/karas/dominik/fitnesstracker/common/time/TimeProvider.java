package karas.dominik.fitnesstracker.common.time;

import java.time.Instant;

public interface TimeProvider {

    Instant now();
}
