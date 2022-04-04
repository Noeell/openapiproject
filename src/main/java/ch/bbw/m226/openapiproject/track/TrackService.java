package ch.bbw.m226.openapiproject.track;

import ch.bbw.m226.openapi.generated.dto.TrackDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Collection;
import java.util.HashMap;
import java.util.Optional;
import java.util.UUID;

@Service
public class TrackService {

    @PostConstruct
    public void someInitialTracks() {
        createTrack(new TrackDto().name("Red Bull Ring").country("Austria").location("Steiermark").rounds(60).lenght(5.55));
    }

    private HashMap<String, TrackDto> tracksList = new HashMap<>();

    public Collection<TrackDto> getTracks() {
        return tracksList.values();
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
