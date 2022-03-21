package ch.bbw.m226.openapiproject.Driver;

import ch.bbw.m226.openapi.generated.dto.DriverDto;
import ch.bbw.m226.openapi.generated.dto.RacingTeamDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class DriverService {

    @PostConstruct
    public void someInitialHorses() {
       createDriver(new DriverDto().name("Verstappen").prename("Max").age(20).country("Niederlande").points(0).racingTeam(new RacingTeamDto().name("RedBull").teamBoss("Christian Horner").country("Austria").points(0).engineProducer("Honda")));

    }
    private List<DriverDto> driversList = new ArrayList<>();

    public List<DriverDto> getDrivers() {
        return driversList;
    }

    public void createDriver(DriverDto newDriver){
        driversList.add(newDriver);
    }
}
