package ch.bbw.m226.openapiproject.RacingTeam;

import ch.bbw.m226.openapi.generated.dto.RacingTeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("v1/f1/racingteam")
public class RacingTeamController {

    @Autowired
    private RacingTeamService service;

    @GetMapping()
    public Collection<RacingTeamDto> getAllRacingTeams() {
        return service.getRacingTeams();
    }

    @GetMapping("{uuid}")
    public ResponseEntity<RacingTeamDto> getDriverByUuid(@PathVariable String uuid) {
        return service.getRacingTeamByUuid(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity createRacingTeam(@RequestBody RacingTeamDto newRacingTeam) {
        service.createRacingTeam(newRacingTeam);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("{uuid}")
    public ResponseEntity<RacingTeamDto> updateDriver(@PathVariable String uuid, @RequestBody RacingTeamDto updatedRacingTeam) {
        return service.updateRacingTeam(uuid, updatedRacingTeam)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<RacingTeamDto> deleteRacingTeam(@PathVariable String uuid) {
        return service.deleteRacingTeam(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
