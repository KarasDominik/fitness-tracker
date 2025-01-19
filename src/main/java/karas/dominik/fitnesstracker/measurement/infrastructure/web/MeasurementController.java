package karas.dominik.fitnesstracker.measurement.infrastructure.web;

import karas.dominik.fitnesstracker.common.LoggedUserProvider;
import karas.dominik.fitnesstracker.common.TimeProvider;
import karas.dominik.fitnesstracker.measurement.MeasurementService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import static karas.dominik.fitnesstracker.measurement.infrastructure.web.Request2CommandMapper.asCommand;
import static org.springframework.http.HttpStatus.CREATED;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/measurement")
class MeasurementController {

    private final MeasurementService service;
    private final LoggedUserProvider loggedUserProvider;
    private final TimeProvider timeProvider;

    @PostMapping
    @ResponseStatus(CREATED)
    CreateMeasurementResponse create(@RequestBody CreateMeasurementRequest request) {
        var loggedUser = loggedUserProvider.getLoggedUser();
        return CreateMeasurementResponse.of(service.create(asCommand(request, loggedUser.id(), timeProvider::now)));
    }
}
