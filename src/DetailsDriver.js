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
                                    Age: {driver?.age} <br/>
                                    Country: {driver?.country}<br/>
                                    Points: {driver?.points}
                                </Typography>
                            </CardContent>
                            <CardActions>
                                <Button size="small">Share</Button>
                                <Button size="small">Learn More</Button>
                            </CardActions>
                        </Card>
                    </Col>
                    <Col>
                        <Card sx={{ maxWidth: 450 }}>
                            <CardMedia
                                component="img"
                                height="300"
                                image={"https://source.unsplash.com/300x300/?" + racingTeam?.name + " logo"}
                                alt="green iguana"
                            />
                            <CardContent>
                                <Typography gutterBottom variant="h5" component="div">
                                    {racingTeam?.name}
                                </Typography>
                                <Typography variant="body2" color="text.secondary">
                                    Team Boss: {racingTeam?.teamBoss} <br/>
                                    Country: {racingTeam?.country}<br/>
                                    Engine Producer: {racingTeam?.engineProducer}<br/>
                                    Points: {racingTeam?.points}
                                </Typography>
                            </CardContent>
                            <CardActions>
                                <Button size="small">Share</Button>
                                <Button size="small">Learn More</Button>
                            </CardActions>
                        </Card>
                    </Col>
                </Row>
            </Container>
        </>
    );

}

export default DetailsDriver;