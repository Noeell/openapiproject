package ch.bbw.m226.openapiproject.RacingTeam;

import ch.bbw.m226.openapi.generated.controller.RacingteamApi;
import ch.bbw.m226.openapi.generated.dto.RacingTeamDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/f1")
public class RacingTeamController implements RacingteamApi {

    @Autowired
    private RacingTeamService service;

    @Override
    public ResponseEntity<List<RacingTeamDto>> racingteamGet() {
        return ResponseEntity.ok(service.getRacingTeams());
    }

    @Override
    public ResponseEntity<RacingTeamDto> racingteamPost(RacingTeamDto racingTeamDto) {
        service.createRacingTeam(racingTeamDto);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<RacingTeamDto> racingteamUuidDelete(String uuid) {
        return service.deleteRacingTeam(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<RacingTeamDto> racingteamUuidGet(String uuid) {
        return service.getRacingTeamByUuid(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<RacingTeamDto> racingteamUuidPut(String uuid, RacingTeamDto racingTeamDto) {
        return service.updateRacingTeam(uuid, racingTeamDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
