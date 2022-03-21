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
       createDriver(new DriverDto().name("Verstappen").prename("Max").age(24).country("Niederlande").points(0).racingTeam(new RacingTeamDto().name("RedBull").teamBoss("Christian Horner").country("Austria").points(0).engineProducer("Red Bull / Honda")));
       createDriver(new DriverDto().name("Perez").prename("Sergio").age(32).country("Mexiko").points(0).racingTeam(new RacingTeamDto().name("RedBull").teamBoss("Christian Horner").country("Austria").points(0).engineProducer("Red Bull / Honda")));
       createDriver(new DriverDto().name("Ricciardo").prename("Daniel").age(32).country("Australien").points(0).racingTeam(new RacingTeamDto().name("McLaren").teamBoss("Andreas Seidl").country("Gross Britanien").points(0).engineProducer("Mercedes")));
       createDriver(new DriverDto().name("Norris").prename("Lando").age(22).country("Gross Britanien").points(0).racingTeam(new RacingTeamDto().name("McLaren").teamBoss("Andreas Seidl").country("Gross Britanien").points(0).engineProducer("Mercedes")));
       createDriver(new DriverDto().name("Vettel").prename("Sebastian").age(34).country("Deutschland").points(0).racingTeam(new RacingTeamDto().name("Aston Martin").teamBoss("Mike Krack").country("Gross Britanien").points(0).engineProducer("Mercedes")));
       createDriver(new DriverDto().name("Stroll").prename("Lance").age(23).country("Kanada").points(0).racingTeam(new RacingTeamDto().name("Aston Martin").teamBoss("Mike Krack").country("Gross Britanien").points(0).engineProducer("Mercedes")));
       createDriver(new DriverDto().name("Latifi").prename("Nicholas").age(26).country("Kanada").points(0).racingTeam(new RacingTeamDto().name("Wiliams").teamBoss("Jost Capito").country("Gross Britanien").points(0).engineProducer("Mercedes")));
       createDriver(new DriverDto().name("Albon").prename("Alexander").age(25).country("Thailand").points(0).racingTeam(new RacingTeamDto().name("Wiliams").teamBoss("Jost Capito").country("Gross Britanien").points(0).engineProducer("Mercedes")));
       createDriver(new DriverDto().name("Gasly").prename("Pierre").age(26).country("Frankreich").points(0).racingTeam(new RacingTeamDto().name("Apha Tauri").teamBoss("Franz Tost").country("Italien").points(0).engineProducer("Red Bull / Honda")));
       createDriver(new DriverDto().name("Tsunoda").prename("Yuki").age(21).country("Japan").points(0).racingTeam(new RacingTeamDto().name("Apha Tauri").teamBoss("Franz Tost").country("Italien").points(0).engineProducer("Red Bull / Honda")));
       createDriver(new DriverDto().name("Alonso").prename("Fernando").age(40).country("Spanien").points(0).racingTeam(new RacingTeamDto().name("Alpine").teamBoss("Otmar Szafnauer").country("Frankreich").points(0).engineProducer("Renault")));
       createDriver(new DriverDto().name("Ocon").prename("Esteban").age(25).country("Frankreich").points(0).racingTeam(new RacingTeamDto().name("Alpine").teamBoss("Otmar Szafnauer").country("Frankreich").points(0).engineProducer("Renault")));
       createDriver(new DriverDto().name("Leclerc").prename("Charles").age(24).country("Monaco").points(0).racingTeam(new RacingTeamDto().name("Ferrari").teamBoss("Mattia Binotto").country("Italien").points(0).engineProducer("Ferrari")));
       createDriver(new DriverDto().name("Sainz").prename("Carlos").age(27).country("Spanien").points(0).racingTeam(new RacingTeamDto().name("Ferrari").teamBoss("Mattia Binotto").country("Italien").points(0).engineProducer("Ferrari")));
       createDriver(new DriverDto().name("Magnussen").prename("Kevin").age(27).country("Dänemark").points(0).racingTeam(new RacingTeamDto().name("Haas").teamBoss("Günther Steiner").country("USA").points(0).engineProducer("Ferrari")));
       createDriver(new DriverDto().name("Schuhmacher").prename("Mick").age(22).country("Deutschland").points(0).racingTeam(new RacingTeamDto().name("Haas").teamBoss("Günther Steiner").country("USA").points(0).engineProducer("Ferrari")));
       createDriver(new DriverDto().name("Zhou").prename("Guanyu").age(22).country("China").points(0).racingTeam(new RacingTeamDto().name("Alfa Romeo").teamBoss("Frederic Vasseur").country("Schweiz").points(0).engineProducer("Ferrari")));
       createDriver(new DriverDto().name("Bottas").prename("Valtteri").age(32).country("Finnland").points(0).racingTeam(new RacingTeamDto().name("Alfa Romeo").teamBoss("Frederic Vasseur").country("Schweiz").points(0).engineProducer("Ferrari")));
       createDriver(new DriverDto().name("Hamilton").prename("Lewis").age(37).country("Gross Britanien").points(0).racingTeam(new RacingTeamDto().name("Mercedes").teamBoss("Toto Wolff").country("Deutschland").points(0).engineProducer("Mercedes")));
       createDriver(new DriverDto().name("Russell").prename("George").age(24).country("Gross Britanien").points(0).racingTeam(new RacingTeamDto().name("Mercedes").teamBoss("Toto Wolff").country("Deutschland").points(0).engineProducer("Mercedes")));

    }
    private List<DriverDto> driversList = new ArrayList<>();

    public List<DriverDto> getDrivers() {
        return driversList;
    }

    public void createDriver(DriverDto newDriver){
        driversList.add(newDriver);
    }
}
