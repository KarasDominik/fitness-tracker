package karas.dominik.fitnesstracker.measurement.infrastructure.persistence;

import karas.dominik.fitnesstracker.measurement.application.dto.MeasurementId;
import org.springframework.data.repository.CrudRepository;

public interface Measurements extends CrudRepository<Measurement, MeasurementId> {}
