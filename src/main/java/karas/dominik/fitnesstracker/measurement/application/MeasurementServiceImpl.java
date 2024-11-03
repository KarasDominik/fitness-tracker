package karas.dominik.fitnesstracker.measurement.application;

import karas.dominik.fitnesstracker.measurement.MeasurementService;
import karas.dominik.fitnesstracker.measurement.application.dto.CreateMeasurementCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
class MeasurementServiceImpl implements MeasurementService {

    private final CreateMeasurementUseCase createMeasurement;

    @Override
    public UUID create(CreateMeasurementCommand command) {
        return createMeasurement.execute(command);
    }
}
