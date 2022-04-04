import {Container} from "react-bootstrap";
import Header from "./Header";
import {useState} from "react";
import {DriverApi} from "./generated/openapi";

function DetailsDriver() {
    const [driver, setDriver] = useState();

    setDriver(DriverApi.driversUuidGet(uuid))

    return (
        <>
            <Header/>
            <Container>
                <h1>{driver.prename + driver.name}</h1>
            </Container>
        </>
    );

}

export default DetailsDriver;