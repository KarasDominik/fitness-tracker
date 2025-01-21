package karas.dominik.fitnesstracker.measurement.application;

import karas.dominik.fitnesstracker.measurement.MeasurementService;
import karas.dominik.fitnesstracker.measurement.application.dto.CreateMeasurementCommand;
import karas.dominik.fitnesstracker.measurement.application.dto.MeasurementId;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class MeasurementServiceImpl implements MeasurementService {

    private final CreateMeasurementUseCase createMeasurement;

    @Override
    public MeasurementId create(CreateMeasurementCommand command) {
        return createMeasurement.execute(command);
    }
}
