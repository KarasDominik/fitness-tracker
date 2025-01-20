@org.springframework.modulith.ApplicationModule(
        allowedDependencies = {
                "useraccount",
                "measurement"},
        type = OPEN
)
package karas.dominik.fitnesstracker.common;

import static org.springframework.modulith.ApplicationModule.Type.OPEN;