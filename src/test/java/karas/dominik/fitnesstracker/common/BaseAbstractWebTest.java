package karas.dominik.fitnesstracker.common;

import karas.dominik.fitnesstracker.common.config.SecurityConfiguration;
import org.springframework.context.annotation.Import;

@Import(SecurityConfiguration.class)
public class BaseAbstractWebTest {}
