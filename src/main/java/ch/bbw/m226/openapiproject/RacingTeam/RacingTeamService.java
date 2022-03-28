package ch.bbw.m226.openapiproject.RacingTeam;

import ch.bbw.m226.openapi.generated.dto.RacingTeamDto;
import ch.bbw.m226.openapiproject.Driver.DriverService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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

    private List<RacingTeamDto> racingTeamList = new ArrayList<>();

    public List<RacingTeamDto> getRacingTeams() {
        return racingTeamList;
    }

    public void createRacingTeam(RacingTeamDto newRacingTeam) {
        racingTeamList.add(newRacingTeam);
    }
}
