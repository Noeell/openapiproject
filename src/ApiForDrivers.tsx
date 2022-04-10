import {DriverApi, DriverDto, DriversApi, RacingTeamDto, RacingTeamsApi} from "./generated/openapi";


const api = new DriversApi();
const driverApi = new DriverApi();
const racingTeamApi = new RacingTeamsApi();

export function getDrivers(): Promise<Array<DriverDto>> {
    return api.driversGet();
}

export function getDriverByUuid(uuid: string): Promise<DriverDto> {
    return driverApi.driversUuidGet({
        uuid: uuid
    });
}

export function driversUuidDelete(uuid: string): Promise<DriverDto> {
    return driverApi.driversUuidDelete({
        uuid: uuid
    });
}

export function addNewDriver(driver: DriverDto): Promise<DriverDto> {
    return api.driversPost({
        driverDto: driver
    });
}

export function getRacingTeams(): Promise<Array<RacingTeamDto>> {
    return racingTeamApi.racingteamGet();
}

export function updateDriver(driver: DriverDto, uuid: string): Promise<DriverDto> {
    return driverApi.driversUuidPut({
        uuid: uuid,
        driverDto: driver
    });
}