import {Button, Col, Container, Row} from "react-bootstrap";
import Header from "./Header";
import {DataGrid} from '@mui/x-data-grid';
import {addNewDriver, driversUuidDelete, getDriverByUuid, getDrivers, getRacingTeams} from "./ApiForDrivers";
import {useEffect, useState} from "react";
import {Card, FormControl, InputLabel, MenuItem, Select, TextField} from "@mui/material";
import Loading from "./Loading";

function Drivers() {
    const [drivers, setDrivers] = useState([]);
    const [racingTeams, setRacingTeams] = useState([]);
    const [selectedRacingTeam, setSelectedRacingTeam] = useState({});
    const [selectedRow, setSelectedRow] = useState();
    const [editedCell, setEditedCell] = useState();
    const [insertPressed, setInsertPressed] = useState();
    const [pageSize, setPageSize] = useState(5);

    const [firstName, setFirstName] = useState();
    const [lastName, setLastName] = useState();
    const [age, setAge] = useState();
    const [country, setCountry] = useState();
    const [points, setPoints] = useState();

    const [isPending, setIsPending] = useState(true);

    useEffect(() => {
        loadAllEntries()
    }, [])

    useEffect(() => {
        getRacingTeams()
            .then(data => setRacingTeams(data))
            .catch(error => console.error(error));
    }, [insertPressed])

    function loadAllEntries() {
        setIsPending(true);
        console.log(drivers);
        getDrivers()
            .then(data => {
                setIsPending(false);
                setDrivers(data);
            })
            .catch(error => console.error(error));
    }

    const columns = [
        {field: 'uuid', headerName: 'Id', width: 350},
        {field: 'prename', headerName: 'First name', width: 150, editable: true},
        {field: 'name', headerName: 'Last name', width: 150, editable: true},
        {
            field: 'age',
            headerName: 'Age',
            type: 'number',
            width: 100,
            editable: true
        },
        {
            field: 'country',
            headerName: 'Country',
            width: 200,
            editable: true
        }
    ];

    function insertEntry() {
        if (firstName?.trim() !== "" && lastName?.trim() !== "" && age !== 0 && country?.trim() !== "" && firstName !== undefined && lastName !== undefined && country !== undefined) {
            let newDriver;
            if (selectedRacingTeam.country !== undefined) {
                newDriver = {
                    name: lastName,
                    prename: firstName,
                    age: age,
                    points: points,
                    country: country,
                    racingTeam: selectedRacingTeam
                }
            } else {
                newDriver = {
                    name: lastName,
                    prename: firstName,
                    age: age,
                    points: points,
                    country: country,
                }
            }

            addNewDriver(newDriver)
                .catch(error => console.error(error))
                .finally(loadAllEntries);
            setInsertPressed(false);
            setSelectedRacingTeam({});
        }

    }

    function deleteRow(listOfUuid) {
        for (let i = 0; i < listOfUuid.length; i++) {
            driversUuidDelete(listOfUuid[i])
                .then(loadAllEntries)
                .catch(error => console.error(error));
        }
    }

    function updateRow() {
        let driverData;
        console.log(selectedRow)
        getDriverByUuid(selectedRow)
            .then(data => driverData = data)
            .catch(error => console.error(error));

        console.log(driverData)
        console.log(editedCell)
    }

    return (
        <>
            <Header/><br/>
            <Container>
                <Row>
                    <Col>
                        <h2>Drivers</h2>
                    </Col>
                </Row><br/>{isPending && <Loading/>}
                <Row>
                    {drivers.length > 0 && <DataGrid
                        rows={drivers}
                        columns={columns}
                        pageSize={pageSize}
                        onPageSizeChange={(newPageSize) => setPageSize(newPageSize)}
                        rowsPerPageOptions={[5, 10, 20]}
                        pagination
                        checkboxSelection
                        autoWidth
                        autoHeight
                        getRowId={row => row.uuid}
                        onSelectionModelChange={itm => setSelectedRow(itm)}
                        onEditRowsModelChange={dd => console.log(dd)}
                    />}
                </Row><br/>
                <Row>
                    <Col>
                        <Button onClick={() => setInsertPressed(true)}>Insert</Button>
                    </Col>
                    <Col>
                        <Button onClick={updateRow}>Update</Button>
                    </Col>
                    <Col>
                        <Button onClick={() => deleteRow(selectedRow)}>Delete</Button>
                    </Col>
                </Row><br/><br/>
                {insertPressed && <Row>
                    <Card sx={{maxWidth: 250}}><br/>
                        <h4>New entry:</h4>
                        <TextField id="standard-basic" label="First name" variant="standard"
                                   onChange={e => setFirstName(e.target.value)}/>
                        <TextField id="standard-basic" label="Last name" variant="standard"
                                   onChange={e => setLastName(e.target.value)}/>
                        <TextField id="standard-basic" label="age" variant="standard" type={"number"}
                                   onChange={e => setAge(e.target.value)}/>
                        <TextField id="standard-basic" label="Country" variant="standard"
                                   onChange={e => setCountry(e.target.value)}/>
                        <TextField id="standard-basic" label="Points" variant="standard" type={"number"}
                                   onChange={e => setPoints(e.target.value)}/><br/><br/>
                        <InputLabel variant={"standard"}>Racing Team</InputLabel>
                        <FormControl variant={"standard"} fullWidth>
                            <Select>
                                <MenuItem onClick={() => setSelectedRacingTeam({})}>
                                    None
                                </MenuItem>
                                {racingTeams.map((team, idx) => <MenuItem onClick={() => setSelectedRacingTeam(team)}
                                                                          key={idx}
                                                                          value={team}>{team.name}</MenuItem>)}
                            </Select>
                        </FormControl>
                        <br/><br/><br/>
                        <Button onClick={insertEntry} width={"30px"}>Add</Button>
                    </Card>
                </Row>}
            </Container>
        </>
    );
}

export default Drivers;