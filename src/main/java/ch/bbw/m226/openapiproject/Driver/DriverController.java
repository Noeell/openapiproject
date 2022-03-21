package ch.bbw.m226.openapiproject.Driver;

import ch.bbw.m226.openapi.generated.controller.DriverApi;
import ch.bbw.m226.openapi.generated.dto.DriverDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/f1/driver")
public class DriverController implements DriverApi {

    @Autowired
    private DriverService service;

    @GetMapping()
    public List<DriverDto> getDrivers() {
        return service.getDrivers();
    }

    @PostMapping()
    public void createDriver(@RequestBody DriverDto newDriver) {
        service.createDriver(newDriver);
    }

    @Override
    public ResponseEntity<List<DriverDto>> driverGet(Integer limit) {
        return null;
    }
}
