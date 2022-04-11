import {TrackApi, TrackDto, TracksApi} from "./generated/openapi";

const tracksApi = new TracksApi();
const trackApi = new TrackApi();

export function getTracks(): Promise<Array<TrackDto>> {
    return tracksApi.tracksGet();
}

export function getTrackByUuid(uuid: string): Promise<TrackDto> {
    return trackApi.tracksUuidGet({
        uuid: uuid
    });
}

export function addNewTrack(track: TrackDto): Promise<TrackDto> {
    return tracksApi.tracksPost({
        trackDto: track
    });
}

export function tracksUuidDelete(uuid: string): Promise<TrackDto> {
    return trackApi.tracksUuidDelete({
        uuid: uuid
    });
}

export function updateTrack(track: TrackDto, uuid: string): Promise<TrackDto> {
    return trackApi.tracksUuidPut({
        uuid: uuid,
        trackDto: track
    });
}