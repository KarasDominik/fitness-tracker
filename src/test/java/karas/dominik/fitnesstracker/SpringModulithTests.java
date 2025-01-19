package karas.dominik.fitnesstracker;

import com.tngtech.archunit.core.domain.JavaClass;
import org.junit.jupiter.api.Test;
import org.springframework.modulith.core.ApplicationModules;

public class SpringModulithTests {

    private final ApplicationModules modules = ApplicationModules.of(FitnesstrackerApplication.class,
            JavaClass.Predicates.resideInAPackage("karas.dominik.fitnesstracker.common.."));

    @Test
    void shouldBeCompliant() {
        modules.verify();
    }
}