package karas.dominik.fitnesstracker.measurement.infrastructure.web;

import karas.dominik.fitnesstracker.measurement.application.dto.MeasurementId;

record CreateMeasurementResponse(MeasurementId id) {

    static CreateMeasurementResponse of(MeasurementId id) {
        return new CreateMeasurementResponse(id);
    }
}
