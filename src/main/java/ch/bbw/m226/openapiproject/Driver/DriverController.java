package ch.bbw.m226.openapiproject.Driver;

import ch.bbw.m226.openapi.generated.controller.DriverApi;
import ch.bbw.m226.openapi.generated.dto.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@RequestMapping("v1/f1/drivers")
public class DriverController implements DriverApi {

    @Autowired
    private DriverService service;

    @GetMapping()
    public Collection<DriverDto> getDrivers() {
        return service.getDrivers();
    }

    @GetMapping("{uuid}")
    public ResponseEntity<DriverDto> getDriverByUuid(@PathVariable String uuid) {
        return service.getDriverByUuid(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity createDriver(@RequestBody DriverDto newDriver) {
        service.createDriver(newDriver);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("{uuid}")
    public ResponseEntity<DriverDto> updateDriver(@PathVariable String uuid, @RequestBody DriverDto updatedDriver) {
        return service.updateDriver(uuid, updatedDriver)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<DriverDto> deleteDriver(@PathVariable String uuid) {
        return service.deleteDriver(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<List<DriverDto>> driverGet(Integer limit) {
        return null;
    }
}
