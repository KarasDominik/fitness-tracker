package karas.dominik.fitnesstracker;

import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class SpringModulithTests {

    private final ApplicationModules modules = ApplicationModules.of(FitnesstrackerApplication.class);

    @Test
    void shouldBeCompliant() {
        modules.verify();
    }
}