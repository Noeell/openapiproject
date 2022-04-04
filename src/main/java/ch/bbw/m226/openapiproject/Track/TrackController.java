package ch.bbw.m226.openapiproject.Track;

import ch.bbw.m226.openapi.generated.dto.TrackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("v1/f1/tracks")
public class TrackController {

    @Autowired
    private TrackService service;

    @GetMapping
    public Collection<TrackDto> getTracks() {
        return service.getTracks();
    }

    @GetMapping("{uuid}")
    public ResponseEntity<TrackDto> getTrackByUuid(@PathVariable String uuid) {
        return service.getTracksByUuid(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping()
    public ResponseEntity createTrack(@RequestBody TrackDto newTrack) {
        service.createTrack(newTrack);
        return ResponseEntity.status(201).build();
    }

    @PutMapping("{uuid}")
    public ResponseEntity<TrackDto> updateTrack(@PathVariable String uuid, @RequestBody TrackDto updatedTrack) {
        return service.updatedTrack(uuid, updatedTrack)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("{uuid}")
    public ResponseEntity<TrackDto> deleteTrack(@PathVariable String uuid) {
        return service.deleteTrack(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
