package ch.bbw.m226.openapiproject;

import ch.bbw.m226.openapi.generated.dto.TrackDto;
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
public class TracksApplicationTest implements WithAssertions {

    @Autowired
    private WebTestClient webClient;

    @Test
    void getAllTracks() {
        var racingTeams = webClient.get()
                .uri("/v1/f1/tracks")
                .exchange()
                .expectStatus()
                .isOk()
                .expectBodyList(TrackDto.class)
                .returnResult()
                .getResponseBody();

        assertThat(racingTeams).hasSizeGreaterThanOrEqualTo(21);
    }

    @Test
    void addTrack() {
        var toCreate = new TrackDto().name("Bahrain International Circuit").country("Bahrain").location("Sachir").rounds(57).lenght(5.412);
        webClient.post()
                .uri("/v1/f1/tracks")
                .bodyValue(toCreate)
                .exchange()
                .expectStatus()
                .isCreated();
    }

    @Test
    void deleteByUnknownUuid() {
        UUID uuid = UUID.randomUUID();

        webClient.delete()
                .uri("/v1/f1/tracks/" + uuid)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void updateByUnknownUuid() {
        UUID uuid = UUID.randomUUID();
        var toCreate = new TrackDto().name("Bahrain International Circuit").country("Bahrain").location("Sachir").rounds(57).lenght(5.412);

        webClient.put()
                .uri("/v1/f1/tracks/" + uuid)
                .bodyValue(toCreate)
                .exchange()
                .expectStatus()
                .isNotFound();
    }

    @Test
    void getRacingTeamByUnknownUuid() {
        UUID uuid = UUID.randomUUID();

        webClient.get()
                .uri("/v1/f1/tracks/" + uuid)
                .exchange()
                .expectStatus()
                .isNotFound();
    }
}