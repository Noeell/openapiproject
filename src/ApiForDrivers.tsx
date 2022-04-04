import {DriversApi, DriverApi, DriverDto} from "./generated/openapi";
import exp from "constants";


const api = new DriversApi();
const driverApi = new DriverApi();

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

/*
export function addDriver(name: string): Promise<DriverDto> {
    return api.addPony({
        ponyDto: {
            name: name,
            birthday: birthday
        }
    });
}*/
