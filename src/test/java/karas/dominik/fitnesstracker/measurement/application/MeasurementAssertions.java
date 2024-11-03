package karas.dominik.fitnesstracker.measurement.application;

import karas.dominik.fitnesstracker.measurement.infrastructure.persistence.Measurement;
import karas.dominik.fitnesstracker.measurement.infrastructure.persistence.Measurements;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.springframework.stereotype.Component;

import java.util.Map;
import java.util.UUID;

import static org.assertj.core.api.Assertions.assertThat;

@Component
@RequiredArgsConstructor
public class MeasurementAssertions {

    private final Measurements measurements;

    public void assertMeasurementCreated(UUID id, Map<String, Object> expected) {
        assertThat(measurements.findById(id).orElseThrow())
                .satisfies(measurement -> MeasurementAssert.assertThat(measurement)
                        .hasUserId(UUID.fromString(expected.get("userId").toString()))
                        .hasWeight(Double.parseDouble(expected.get("weight").toString()))
                        .hasCalf(Double.parseDouble(expected.get("calf").toString()))
                        .hasThigh(Double.parseDouble(expected.get("thigh").toString()))
                        .hasHips(Double.parseDouble(expected.get("hips").toString()))
                        .hasBelly(Double.parseDouble(expected.get("belly").toString()))
                        .hasWaist(Double.parseDouble(expected.get("waist").toString()))
                        .hasChest(Double.parseDouble(expected.get("chest").toString()))
                        .hasArm(Double.parseDouble(expected.get("arm").toString()))
                        .hasForearm(Double.parseDouble(expected.get("forearm").toString())));
    }

    static class MeasurementAssert extends AbstractAssert<MeasurementAssert, Measurement> {

            MeasurementAssert(Measurement actual) {
                super(actual, MeasurementAssert.class);
                isNotNull();
            }

            static MeasurementAssert assertThat(Measurement actual) {
                return new MeasurementAssert(actual);
            }

        MeasurementAssert hasUserId(UUID expected) {
            Assertions.assertThat(actual.getUserId())
                    .as("Expected measurement to have user id <%s> but was <%s>", expected, actual.getUserId())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasWeight(double expected) {
            Assertions.assertThat(actual.getWeight())
                    .as("Expected measurement to have weight <%s> but was <%s>", expected, actual.getWeight())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasCalf(double expected) {
            Assertions.assertThat(actual.getCalf())
                    .as("Expected measurement to have calf <%s> but was <%s>", expected, actual.getCalf())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasThigh(double expected) {
            Assertions.assertThat(actual.getThigh())
                    .as("Expected measurement to have thigh <%s> but was <%s>", expected, actual.getThigh())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasHips(double expected) {
            Assertions.assertThat(actual.getHips())
                    .as("Expected measurement to have hips <%s> but was <%s>", expected, actual.getHips())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasBelly(double expected) {
            Assertions.assertThat(actual.getBelly())
                    .as("Expected measurement to have belly <%s> but was <%s>", expected, actual.getBelly())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasWaist(double expected) {
            Assertions.assertThat(actual.getWaist())
                    .as("Expected measurement to have waist <%s> but was <%s>", expected, actual.getWaist())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasChest(double expected) {
            Assertions.assertThat(actual.getChest())
                    .as("Expected measurement to have chest <%s> but was <%s>", expected, actual.getChest())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasArm(double expected) {
            Assertions.assertThat(actual.getArm())
                    .as("Expected measurement to have arm <%s> but was <%s>", expected, actual.getArm())
                    .isEqualTo(expected);
            return this;
        }

        void hasForearm(double expected) {
            Assertions.assertThat(actual.getForearm())
                    .as("Expected measurement to have forearm <%s> but was <%s>", expected, actual.getForearm())
                    .isEqualTo(expected);
        }
    }
}
