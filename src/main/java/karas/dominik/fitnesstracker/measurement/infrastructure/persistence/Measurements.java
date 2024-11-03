package karas.dominik.fitnesstracker.measurement.infrastructure.persistence;

import org.springframework.data.repository.CrudRepository;

import java.util.UUID;

public interface Measurements extends CrudRepository<Measurement, UUID> {}
