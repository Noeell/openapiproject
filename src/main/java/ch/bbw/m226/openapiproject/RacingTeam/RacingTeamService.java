package ch.bbw.m226.openapiproject.RacingTeam;

import ch.bbw.m226.openapi.generated.dto.DriverDto;
import ch.bbw.m226.openapi.generated.dto.RacingTeamDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

@Service
public class RacingTeamService {

    @PostConstruct
    public void someInitialHorses() {
        createRacingTeam(new RacingTeamDto().name("RedBull").teamBoss("Christian Horner").country("Austria").points(0).engineProducer("Honda"));

    }
    private List<RacingTeamDto> racingTeamList = new ArrayList<>();

    public List<RacingTeamDto> getRacingTeams() {
        return racingTeamList;
    }

    public void createRacingTeam(RacingTeamDto newRacingTeam){
        racingTeamList.add(newRacingTeam);
    }
}
