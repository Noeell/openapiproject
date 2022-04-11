package ch.bbw.m226.openapiproject;

import ch.bbw.m226.openapi.generated.dto.RacingTeamDto;
import ch.bbw.m226.openapiproject.Driver.DriverService;
import ch.bbw.m226.openapiproject.RacingTeam.RacingTeamService;
import ch.bbw.m226.openapiproject.Track.TrackService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.context.annotation.Import;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.UUID;


@WebFluxTest
@ExtendWith(SpringExtension.class)
@Import({RacingTeamService.class, DriverService.class, TrackService.class})
public class RacingTeamApplicationTest implements WithAssertions {

    @Autowired
    private WebTestClient webClient;

    @Test
    void getAllRacingTeams(){
        var racingTeams = webClient.get()
                .uri("/v1/f1/racingteam")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(RacingTeamDto.class)
                .returnResult()
                .getResponseBody();

        assertThat(racingTeams).hasSizeGreaterThanOrEqualTo(9);
    }

    @Test
    void addRacingTeam() {
        var toCreate = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("RedBull").teamBoss("Christian Horner").country("Austria").points(0).engineProducer("Red Bull / Honda");
        webClient.post()
                .uri("/v1/f1/racingteam")
                .bodyValue(toCreate)
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @Test
    void deleteByUnknownUuid(){
        UUID uuid = UUID.randomUUID();

        webClient.delete()
                .uri("/v1/f1/racingteam/" + uuid)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void updateByUnknownUuid(){
        UUID uuid = UUID.randomUUID();
        var toCreate = new RacingTeamDto().uuid(UUID.randomUUID().toString()).name("RedBull").teamBoss("Christian Horner").country("Austria").points(0).engineProducer("Red Bull / Honda");

        webClient.put()
                .uri("/v1/f1/racingteam/" + uuid)
                .bodyValue(toCreate)
                .exchange()
                .expectStatus()
                .isNotFound();
    }
}
