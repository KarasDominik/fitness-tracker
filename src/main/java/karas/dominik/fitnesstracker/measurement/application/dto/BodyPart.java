package karas.dominik.fitnesstracker.measurement.application.dto;

public enum BodyPart {
    CALF,
    THIGH,
    HIPS,
    WAIST,
    BELLY,
    CHEST,
    ARM,
    FOREARM;

    public String asCamelCase() {
        return Character.toUpperCase(name().charAt(0)) + name().substring(1).toLowerCase();
    }
}
