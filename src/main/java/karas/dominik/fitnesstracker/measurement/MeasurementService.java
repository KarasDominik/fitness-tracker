package karas.dominik.fitnesstracker.measurement;

import karas.dominik.fitnesstracker.measurement.application.dto.CreateMeasurementCommand;
import karas.dominik.fitnesstracker.measurement.application.dto.MeasurementId;

public interface MeasurementService {

    MeasurementId create(CreateMeasurementCommand command);
}
