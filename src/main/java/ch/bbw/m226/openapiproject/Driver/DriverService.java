package ch.bbw.m226.openapiproject.Driver;

import ch.bbw.m226.openapi.generated.dto.DriverDto;
import ch.bbw.m226.openapi.generated.dto.RacingTeamDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.*;

@Service
public class DriverService {
    public RacingTeamDto redBull = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("RedBull").teamBoss("Christian Horner").country("Austria").points(0).engineProducer("Red Bull / Honda");
    public RacingTeamDto mcLaren = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("McLaren").teamBoss("Andreas Seidl").country("Gross Britanien").points(0).engineProducer("Mercedes");
    public RacingTeamDto astonMartin = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("Aston Martin").teamBoss("Mike Krack").country("Gross Britanien").points(0).engineProducer("Mercedes");
    public RacingTeamDto williams = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("Wiliams").teamBoss("Jost Capito").country("Gross Britanien").points(0).engineProducer("Mercedes");
    public RacingTeamDto alphaTauri = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("Alpha Tauri").teamBoss("Franz Tost").country("Italien").points(0).engineProducer("Red Bull / Honda");
    public RacingTeamDto alpine = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("Alpine").teamBoss("Otmar Szafnauer").country("Frankreich").points(0).engineProducer("Renault");
    public RacingTeamDto ferrari = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("Ferrari").teamBoss("Mattia Binotto").country("Italien").points(0).engineProducer("Ferrari");
    public RacingTeamDto haas = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("Haas").teamBoss("Günther Steiner").country("USA").points(0).engineProducer("Ferrari");
    public RacingTeamDto alfaRomeo = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("Alfa Romeo").teamBoss("Frederic Vasseur").country("Schweiz").points(0).engineProducer("Ferrari");
    public RacingTeamDto mercedes = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("Mercedes").teamBoss("Toto Wolff").country("Deutschland").points(0).engineProducer("Mercedes");

    @PostConstruct
    public void someInitialDrivers() {
        createDriver(new DriverDto().name("Verstappen").prename("Max").age(24).country("Niederlande").points(0).racingTeam(redBull));
        createDriver(new DriverDto().name("Perez").prename("Sergio").age(32).country("Mexiko").points(0).racingTeam(redBull));
        createDriver(new DriverDto().name("Ricciardo").prename("Daniel").age(32).country("Australien").points(0).racingTeam(mcLaren));
        createDriver(new DriverDto().name("Norris").prename("Lando").age(22).country("Gross Britanien").points(0).racingTeam(mcLaren));
        createDriver(new DriverDto().name("Vettel").prename("Sebastian").age(34).country("Deutschland").points(0).racingTeam(astonMartin));
        createDriver(new DriverDto().name("Stroll").prename("Lance").age(23).country("Kanada").points(0).racingTeam(astonMartin));
        createDriver(new DriverDto().name("Latifi").prename("Nicholas").age(26).country("Kanada").points(0).racingTeam(williams));
        createDriver(new DriverDto().name("Albon").prename("Alexander").age(25).country("Thailand").points(0).racingTeam(williams));
        createDriver(new DriverDto().name("Gasly").prename("Pierre").age(26).country("Frankreich").points(0).racingTeam(alphaTauri));
        createDriver(new DriverDto().name("Tsunoda").prename("Yuki").age(21).country("Japan").points(0).racingTeam(alphaTauri));
        createDriver(new DriverDto().name("Alonso").prename("Fernando").age(40).country("Spanien").points(0).racingTeam(alpine));
        createDriver(new DriverDto().name("Ocon").prename("Esteban").age(25).country("Frankreich").points(0).racingTeam(alpine));
        createDriver(new DriverDto().name("Leclerc").prename("Charles").age(24).country("Monaco").points(0).racingTeam(ferrari));
        createDriver(new DriverDto().name("Sainz").prename("Carlos").age(27).country("Spanien").points(0).racingTeam(ferrari));
        createDriver(new DriverDto().name("Magnussen").prename("Kevin").age(27).country("Dänemark").points(0).racingTeam(haas));
        createDriver(new DriverDto().name("Schuhmacher").prename("Mick").age(22).country("Deutschland").points(0).racingTeam(haas));
        createDriver(new DriverDto().name("Zhou").prename("Guanyu").age(22).country("China").points(0).racingTeam(alfaRomeo));
        createDriver(new DriverDto().name("Bottas").prename("Valtteri").age(32).country("Finnland").points(0).racingTeam(alfaRomeo));
        createDriver(new DriverDto().name("Hamilton").prename("Lewis").age(37).country("Grossbritanien").points(0).racingTeam(mercedes));
        createDriver(new DriverDto().name("Russell").prename("George").age(24).country("Grossbritanien").points(0).racingTeam(mercedes));
    }

    private HashMap<String, DriverDto> driversList = new HashMap<>();

    public Collection<DriverDto> getDrivers() {
        return driversList.values();
    }

    public void createDriver(DriverDto newDriver) {
        String id = UUID.randomUUID().toString();
        newDriver.uuid(id);
        driversList.put(id, newDriver);
    }

    public Optional<DriverDto> getDriverByUuid(String uuid){
        if(driversList.containsKey(uuid)){
            return Optional.of(driversList.get(uuid));
        }
        return Optional.empty();
    }
    public Optional<DriverDto> updateDriver(String uuid,DriverDto updatedDriver) {
        if(driversList.containsKey(uuid)) {
            driversList.put(uuid, updatedDriver.uuid(uuid));
            return Optional.of(updatedDriver);
        }
        return Optional.empty();
    }
}
