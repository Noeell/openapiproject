package ch.bbw.m226.openapiproject.Track;

import ch.bbw.m226.openapi.generated.dto.TrackDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrackService {

    @PostConstruct
    public void someInitialTracks() {
        createTrack(new TrackDto().name("Bahrain International Circuit").country("Bahrain").location("Sachir").rounds(57).lenght(5.412));
        createTrack(new TrackDto().name("Jeddah Corniche Circuit").country("Saudi Arabia").location("Jeddah").rounds(50).lenght(6.175));
        createTrack(new TrackDto().name("Albert Park Circuit").country("Australia").location("Melbourne").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Autodromo Enzo e Dino Ferrari").country("Italy").location("Imola").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Miami International Autodrome").country("USA").location("Miami").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Circuit de Barcelona-Catalunya").country("Spain").location("Barcelona").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Circuit de Monte Carlo").country("Monaco").location("Monaco").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Baku City Circuit").country("Azerbaijan").location("Baku").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Circuit Gilles-Villeneuve").country("Canada").location("Montreal").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Silverstone Circuit").country("Great Britain").location("Towcester").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Red Bull Ring").country("Austria").location("Steiermark").rounds(60).lenght(5.55));
        createTrack(new TrackDto().name("Circuit Paul Ricard").country("France").location("La Castellet").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Hungaroring").country("Hungaria").location("Budapest").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Circuit Spa-Francorchamps").country("Belgium").location("Stavelot").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Circuit Zandvoort").country("Dutch").location("Zandvoort").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Autodromo Nazionale Monza").country("Italy").location("Monza").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Marina Bay Circuit").country("Singapore").location("Singapore").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Suzuka").country("Japan").location("Suzuka").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Circuit of the Americas").country("USA").location("Austin").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Autódromo Hermanos Rodríguez").country("Mexico").location("Mexico City").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Autódromo José Carlos Pace").country("Brasilia").location("Interlagos").rounds(0).lenght(0.1));
        createTrack(new TrackDto().name("Yas Marina Circuit").country("Abu Dhabi").location("Yas Marina").rounds(0).lenght(0.1));
    }

    private HashMap<String, TrackDto> tracksList = new HashMap<>();

    public List<TrackDto> getTracks() {
        return tracksList.values().stream().toList();
    }

    public Optional<TrackDto> getTracksByUuid(String uuid) {
        if (tracksList.containsKey(uuid)) {
            return Optional.of(tracksList.get(uuid));
        }
        return Optional.empty();
    }

    public void createTrack(TrackDto newTrack) {
        String id = UUID.randomUUID().toString();
        newTrack.uuid(id);
        tracksList.put(id, newTrack);
    }

    public Optional<TrackDto> updatedTrack(String uuid, TrackDto updatedTrack) {
        if (tracksList.containsKey(uuid)) {
            tracksList.put(uuid, updatedTrack.uuid(uuid));
            return Optional.of(updatedTrack);
        }
        return Optional.empty();
    }

    public Optional<TrackDto> deleteTrack(String uuid) {
        if (tracksList.containsKey(uuid)) {
            return Optional.of(tracksList.remove(uuid));
        }
        return Optional.empty();
    }
}
