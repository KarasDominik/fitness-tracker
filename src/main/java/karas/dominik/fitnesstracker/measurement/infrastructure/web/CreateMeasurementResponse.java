package karas.dominik.fitnesstracker.measurement.infrastructure.web;

import java.util.UUID;

record CreateMeasurementResponse(UUID id) {

    static CreateMeasurementResponse of(UUID id) {
        return new CreateMeasurementResponse(id);
    }
}
