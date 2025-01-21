package karas.dominik.fitnesstracker.measurement.infrastructure.persistence.config;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import karas.dominik.fitnesstracker.measurement.application.dto.MeasurementId;

import java.util.UUID;

@Converter(autoApply = true)
public class MeasurementIdConverter implements AttributeConverter<MeasurementId, UUID> {

    @Override
    public UUID convertToDatabaseColumn(MeasurementId attribute) {
        return attribute.value();
    }

    @Override
    public MeasurementId convertToEntityAttribute(UUID dbData) {
        return MeasurementId.from(dbData);
    }
}
