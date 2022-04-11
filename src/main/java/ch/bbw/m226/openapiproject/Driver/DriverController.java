package ch.bbw.m226.openapiproject.Driver;

import ch.bbw.m226.openapi.generated.controller.DriversApi;
import ch.bbw.m226.openapi.generated.dto.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/f1")
public class DriverController implements DriversApi {

    @Autowired
    private DriverService service;


    @Override
    public ResponseEntity<List<DriverDto>> driversGet() {
        return ResponseEntity.ok(service.getDrivers());
    }

    @Override
    public ResponseEntity<DriverDto> driversPost(DriverDto driverDto) {
        service.createDriver(driverDto);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<DriverDto> driversUuidDelete(String uuid) {
        return service.deleteDriver(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<DriverDto> driversUuidGet(String uuid) {
        return service.getDriverByUuid(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<DriverDto> driversUuidPut(String uuid, DriverDto driverDto) {
        return service.updateDriver(uuid, driverDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
