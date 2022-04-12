package ch.bbw.m226.openapiproject.Track;

import ch.bbw.m226.openapi.generated.controller.TracksApi;
import ch.bbw.m226.openapi.generated.dto.TrackDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("v1/f1")
public class TrackController implements TracksApi {

    @Autowired
    private TrackService service;

    @Override
    public ResponseEntity<List<TrackDto>> tracksGet() {
        return ResponseEntity.ok(service.getTracks());
    }

    @Override
    public ResponseEntity<TrackDto> tracksPost(TrackDto trackDto) {
        service.createTrack(trackDto);
        return ResponseEntity.status(201).build();
    }

    @Override
    public ResponseEntity<TrackDto> tracksUuidDelete(String uuid) {
        return service.deleteTrack(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TrackDto> tracksUuidGet(String uuid) {
        return service.getTracksByUuid(uuid)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Override
    public ResponseEntity<TrackDto> tracksUuidPut(String uuid, TrackDto trackDto) {
        return service.updatedTrack(uuid, trackDto)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }
}
