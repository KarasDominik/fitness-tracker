package karas.dominik.fitnesstracker.config;

import karas.dominik.fitnesstracker.common.TimeProvider;
import lombok.Getter;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.time.Instant;

@Component("timeProvider")
@Profile("test")
@Getter
public class FixedTimeProvider implements TimeProvider {

    private Instant time;

    @Override
    public Instant now() {
        return time;
    }

    public void setNow(Instant time) {
        this.time = time;
    }
}
