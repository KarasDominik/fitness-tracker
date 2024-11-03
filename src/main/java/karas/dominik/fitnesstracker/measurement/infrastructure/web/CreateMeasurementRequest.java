package karas.dominik.fitnesstracker.measurement.infrastructure.web;

record CreateMeasurementRequest(double weight, double calf, double thigh, double hips, double waist, double belly,
                                double chest, double arm, double forearm) {}
