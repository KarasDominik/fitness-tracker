package karas.dominik.fitnesstracker.measurement;

import karas.dominik.fitnesstracker.measurement.application.dto.CreateMeasurementCommand;

import java.util.UUID;

public interface MeasurementService {

    UUID create(CreateMeasurementCommand command);
}
