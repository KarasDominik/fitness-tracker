package karas.dominik.fitnesstracker.measurement.application;

import karas.dominik.fitnesstracker.common.user.UserId;
import karas.dominik.fitnesstracker.measurement.application.dto.MeasurementId;
import karas.dominik.fitnesstracker.measurement.infrastructure.persistence.Measurement;
import karas.dominik.fitnesstracker.measurement.infrastructure.persistence.Measurements;
import lombok.RequiredArgsConstructor;
import org.assertj.core.api.AbstractAssert;
import org.assertj.core.api.Assertions;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.Map;

import static java.time.temporal.ChronoUnit.SECONDS;
import static org.assertj.core.api.Assertions.assertThat;

@Component
@RequiredArgsConstructor
public class MeasurementAssertions {

    private final Measurements measurements;

    public void assertMeasurementCreated(MeasurementId id, Map<String, Object> expected) {
        assertThat(measurements.findById(id).orElseThrow())
                .satisfies(measurement -> MeasurementAssert.assertThat(measurement)
                        .hasUserId(UserId.from(expected.get("userId").toString()))
                        .hasWeight(Double.parseDouble(expected.get("weight").toString()))
                        .hasCalf(Double.parseDouble(expected.get("calf").toString()))
                        .hasThigh(Double.parseDouble(expected.get("thigh").toString()))
                        .hasHips(Double.parseDouble(expected.get("hips").toString()))
                        .hasBelly(Double.parseDouble(expected.get("belly").toString()))
                        .hasWaist(Double.parseDouble(expected.get("waist").toString()))
                        .hasChest(Double.parseDouble(expected.get("chest").toString()))
                        .hasArm(Double.parseDouble(expected.get("arm").toString()))
                        .hasForearm(Double.parseDouble(expected.get("forearm").toString()))
                        .hasCreatedDate(Instant.parse(expected.get("createdDate").toString())));
    }

    static class MeasurementAssert extends AbstractAssert<MeasurementAssert, Measurement> {

            MeasurementAssert(Measurement actual) {
                super(actual, MeasurementAssert.class);
                isNotNull();
            }

            static MeasurementAssert assertThat(Measurement actual) {
                return new MeasurementAssert(actual);
            }

        MeasurementAssert hasUserId(UserId expected) {
            Assertions.assertThat(actual.userId())
                    .as("Expected measurement to have user id <%s> but was <%s>", expected, actual.userId())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasWeight(double expected) {
            Assertions.assertThat(actual.weight())
                    .as("Expected measurement to have weight <%s> but was <%s>", expected, actual.weight())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasCalf(double expected) {
            Assertions.assertThat(actual.calf())
                    .as("Expected measurement to have calf <%s> but was <%s>", expected, actual.calf())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasThigh(double expected) {
            Assertions.assertThat(actual.thigh())
                    .as("Expected measurement to have thigh <%s> but was <%s>", expected, actual.thigh())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasHips(double expected) {
            Assertions.assertThat(actual.hips())
                    .as("Expected measurement to have hips <%s> but was <%s>", expected, actual.hips())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasBelly(double expected) {
            Assertions.assertThat(actual.belly())
                    .as("Expected measurement to have belly <%s> but was <%s>", expected, actual.belly())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasWaist(double expected) {
            Assertions.assertThat(actual.waist())
                    .as("Expected measurement to have waist <%s> but was <%s>", expected, actual.waist())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasChest(double expected) {
            Assertions.assertThat(actual.chest())
                    .as("Expected measurement to have chest <%s> but was <%s>", expected, actual.chest())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasArm(double expected) {
            Assertions.assertThat(actual.arm())
                    .as("Expected measurement to have arm <%s> but was <%s>", expected, actual.arm())
                    .isEqualTo(expected);
            return this;
        }

        MeasurementAssert hasForearm(double expected) {
            Assertions.assertThat(actual.forearm())
                    .as("Expected measurement to have forearm <%s> but was <%s>", expected, actual.forearm())
                    .isEqualTo(expected);
            return this;
        }

        void hasCreatedDate(Instant expected) {
            Assertions.assertThat(actual.date().truncatedTo(SECONDS))
                    .as("Expected measurement to have date <%s> but was <%s>", expected, actual.date())
                    .isEqualTo(expected.truncatedTo(SECONDS));
        }
    }
}
