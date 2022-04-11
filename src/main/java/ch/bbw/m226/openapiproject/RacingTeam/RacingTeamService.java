package ch.bbw.m226.openapiproject.RacingTeam;

import ch.bbw.m226.openapi.generated.dto.RacingTeamDto;
import ch.bbw.m226.openapiproject.Driver.DriverService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class RacingTeamService {
    DriverService driverService;

    public RacingTeamService(DriverService driverService) {
        this.driverService = driverService;
    }

    @PostConstruct
    public void someInitialHorses() {
        createRacingTeam(driverService.ferrari);
        createRacingTeam(driverService.mcLaren);
        createRacingTeam(driverService.alfaRomeo);
        createRacingTeam(driverService.haas);
        createRacingTeam(driverService.alphaTauri);
        createRacingTeam(driverService.williams);
        createRacingTeam(driverService.alpine);
        createRacingTeam(driverService.mercedes);
        createRacingTeam(driverService.redBull);
        createRacingTeam(driverService.astonMartin);
    }

    private HashMap<String, RacingTeamDto> racingTeamList = new HashMap<>();

    public List<RacingTeamDto> getRacingTeams() {
        return racingTeamList.values().stream().toList();
    }

    public Optional<RacingTeamDto> getRacingTeamByUuid(String uuid) {
        if (racingTeamList.containsKey(uuid)) {
            return Optional.of(racingTeamList.get(uuid));
        }
        return Optional.empty();
    }

    public void createRacingTeam(RacingTeamDto newRacingTeam) {
        String id = UUID.randomUUID().toString();
        newRacingTeam.uuid(id);
        racingTeamList.put(id, newRacingTeam);
    }

    public Optional<RacingTeamDto> updateRacingTeam(String uuid, RacingTeamDto updatedRacingTeam) {
        if (racingTeamList.containsKey(uuid)) {
            racingTeamList.put(uuid, updatedRacingTeam.uuid(uuid));
            return Optional.of(updatedRacingTeam);
        }
        return Optional.empty();
    }

    public Optional<RacingTeamDto> deleteRacingTeam(String uuid) {
        if (racingTeamList.containsKey(uuid)) {
            return Optional.of(racingTeamList.remove(uuid));
        }
        return Optional.empty();
    }
}
