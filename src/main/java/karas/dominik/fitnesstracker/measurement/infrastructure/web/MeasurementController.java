package karas.dominik.fitnesstracker.measurement.infrastructure.web;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/measurement")
public class MeasurementController {

    @GetMapping
    String get() {
        return "Hello World!";
    }
}
