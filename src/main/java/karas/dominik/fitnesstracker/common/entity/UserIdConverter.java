package karas.dominik.fitnesstracker.common.entity;

import jakarta.persistence.AttributeConverter;
import jakarta.persistence.Converter;
import karas.dominik.fitnesstracker.common.user.UserId;

import java.util.Optional;
import java.util.UUID;

@Converter(autoApply = true)
public class UserIdConverter implements AttributeConverter<UserId, UUID> {

    @Override
    public UUID convertToDatabaseColumn(UserId attribute) {
        return Optional.ofNullable(attribute)
                .map(UserId::value)
                .orElse(null);
    }

    @Override
    public UserId convertToEntityAttribute(UUID dbData) {
        return Optional.ofNullable(dbData)
                .map(UserId::new)
                .orElse(null);
    }
}
