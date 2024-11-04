package karas.dominik.fitnesstracker.measurement.application;

import karas.dominik.fitnesstracker.measurement.application.dto.CreateMeasurementCommand;
import karas.dominik.fitnesstracker.measurement.infrastructure.persistence.Measurement;
import karas.dominik.fitnesstracker.measurement.infrastructure.persistence.Measurements;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.UUID;

@Service
@RequiredArgsConstructor
@Slf4j
class CreateMeasurementUseCase {

    private final Measurements measurements;

    @Transactional
    public UUID execute(CreateMeasurementCommand command) {
        log.info("Creating new measurement for user {}", command.userId());
        var measurement = Measurement.create(command);
        measurements.save(measurement);
        log.info("Measurement {} created for user {}", measurement.id(), command.userId());
        return measurement.id();
    }
}
