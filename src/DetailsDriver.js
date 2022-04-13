import {Col, Container, Row} from "react-bootstrap";
import Header from "./Header";
import {useEffect, useState} from "react";
import {getDriverByUuid} from "./ApiForDrivers";
import {Button, Card, CardActions, CardContent, CardMedia, Typography} from "@mui/material";

function DetailsDriver() {
    const [driver, setDriver] = useState();
    const [racingTeam, setRacingTeam] = useState();

    let path = window.location.href.toString().split("/");
    let uuid = path[path.length - 1];

    useEffect(() => {
        getDriverByUuid(uuid)
            .then(data => {
                setDriver(data);
                setRacingTeam(data.racingTeam);
            });
    }, []);


    return (
        <>
            <Header/>
            <Container>
                <br/>
                <Row>
                    <Col>
                        <Card sx={{ maxWidth: 450 }}>
                            <CardMedia
                                component="img"
                                height="300"
                                image={"https://source.unsplash.com/300x300/?"+ driver?.prename.toLowerCase() + " " + driver?.name.toLowerCase() + " formula one"}
                                alt={driver?.prename + " " + driver?.name}
                            />
                            <CardContent>
                                <Typography gutterBottom variant="h5" component="div">
                                    {driver?.prename} {driver?.name}
                                </Typography>
                                <Typography variant="body2" color="text.secondary">
                                    Alter: {driver?.age} <br/>
                                    Land: {driver?.country}<br/>
                                    Punkte: {driver?.points}
                                </Typography>
                            </CardContent>
                            <br/>
                            <CardActions>
                                <Button size="small" onClick={() => window.location.href = window.location.hostname + "/#/drivers"}>all Drivers</Button>
                            </CardActions>
                        </Card>
                    </Col>
                    <Col>
                        <Card sx={{ maxWidth: 450 }}>
                            <CardMedia
                                component="img"
                                height="300"
                                image={"https://source.unsplash.com/300x300/?" + racingTeam?.name + " formula 1 logo"}
                                alt="green iguana"
                            />
                            <CardContent>
                                <Typography gutterBottom variant="h5" component="div">
                                    {racingTeam?.name}
                                </Typography>
                                <Typography variant="body2" color="text.secondary">
                                    Team Boss: {racingTeam?.teamBoss} <br/>
                                    Land: {racingTeam?.country}<br/>
                                    Motorenhersteller: {racingTeam?.engineProducer}<br/>
                                    Punkt: {racingTeam?.points}
                                </Typography>
                            </CardContent>
                            <CardActions>
                                <Button size="small" onClick={() => window.location.href = window.location.hostname + "/#/teams"}>all Teams</Button>
                            </CardActions>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </>
    );

}

export default DetailsDriver;