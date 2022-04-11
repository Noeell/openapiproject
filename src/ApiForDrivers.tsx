import {DriverApi, DriverDto, DriversApi, RacingTeamApi, RacingTeamDto, RacingTeamsApi} from "./generated/openapi";

const driversApi = new DriversApi();
const driverApi = new DriverApi();
const racingTeamsApi = new RacingTeamsApi();
const racingTeamApi = new RacingTeamApi();

export function getDrivers(): Promise<Array<DriverDto>> {
    return driversApi.driversGet();
}

export function getDriverByUuid(uuid: string): Promise<DriverDto> {
    return driverApi.driversUuidGet({
        uuid: uuid
    });
}

export function addNewDriver(driver: DriverDto): Promise<DriverDto> {
    return driversApi.driversPost({
        driverDto: driver
    });
}

export function driversUuidDelete(uuid: string): Promise<DriverDto> {
    return driverApi.driversUuidDelete({
        uuid: uuid
    });
}

export function updateDriver(driver: DriverDto, uuid: string): Promise<DriverDto> {
    return driverApi.driversUuidPut({
        uuid: uuid,
        driverDto: driver
    });
}

export function getRacingTeams(): Promise<Array<RacingTeamDto>> {
    return racingTeamsApi.racingteamGet();
}

export function getRacingTeamById(uuid: string): Promise<RacingTeamDto> {
    return racingTeamApi.racingteamUuidGet({
        uuid: uuid
    });
}

export function addRacingTeam(racingTeam: RacingTeamDto): Promise<RacingTeamDto> {
    return racingTeamsApi.racingteamPost({
        racingTeamDto: racingTeam
    });
}

export function deleteRacingTeam(uuid: string): Promise<RacingTeamDto> {
    return racingTeamApi.racingteamUuidDelete({
        uuid: uuid
    });
}

export function updateRacingTeam(racingTeam: RacingTeamDto, uuid: string): Promise<RacingTeamDto> {
    return racingTeamApi.racingteamUuidPut({
        uuid: uuid,
        racingTeamDto: racingTeam
    })
}


