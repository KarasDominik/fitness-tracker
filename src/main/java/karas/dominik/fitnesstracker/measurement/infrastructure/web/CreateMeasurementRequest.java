package karas.dominik.fitnesstracker.measurement.infrastructure.web;

record CreateMeasurementRequest(Double weight, Double calf, Double thigh, Double hips, Double waist, Double belly,
                                Double chest, Double arm, Double forearm) {}
