package ch.bbw.m226.openapiproject.RacingTeam;

import ch.bbw.m226.openapi.generated.dto.RacingTeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/f1/racingteam")
public class RacingTeamController {

    @Autowired
    private RacingTeamService service;

    @GetMapping()
    public List<RacingTeamDto> getAllRacingTeams() {
        return service.getRacingTeams();
    }

    @PostMapping()
    public void createRacingTeam(@RequestBody RacingTeamDto newRacingTeam) {
        service.createRacingTeam(newRacingTeam);
    }

}
