import {Button, Col, Container, Row} from "react-bootstrap";
import Header from "./Header";
import {
    addNewDriver,
    driversUuidDelete,
    getDriverByUuid,
    getDrivers,
    getRacingTeams,
    updateDriver
} from "./ApiForDrivers";
import {useEffect, useState} from "react";
import {
    Alert,
    Autocomplete,
    Box,
    ButtonGroup,
    Card,
    FormControl,
    InputLabel,
    MenuItem,
    Select,
    TextField
} from "@mui/material";
import Loading from "./Loading";
import {data} from "./Countries";
import './drivers.css'
import {DataGrid} from "@mui/x-data-grid";

function Drivers() {
    const [drivers, setDrivers] = useState([]);
    const [racingTeams, setRacingTeams] = useState([]);
    const [selectedRacingTeam, setSelectedRacingTeam] = useState({});
    const [selectedRow, setSelectedRow] = useState([]);
    const [editedRow, setEditedRow] = useState({});
    const [insertPressed, setInsertPressed] = useState();
    const [pageSize, setPageSize] = useState(5);

    const [firstName, setFirstName] = useState("");
    const [lastName, setLastName] = useState("");
    const [age, setAge] = useState();
    const [country, setCountry] = useState("");
    const [points, setPoints] = useState();

    const [isPending, setIsPending] = useState(true);
    const [alert, setAlert] = useState(false);
    const [alertContent, setAlertContent] = useState('');
    const [alertSeverity, setAlertSeverity] = useState('');

    useEffect(() => {
        loadAllEntries();
        if (window.location.href !== "http://localhost:3000/#/drivers"){
            window.location.href = "http://localhost:3000/#/drivers";
        };
    }, [])

    useEffect(() => {
        getRacingTeams()
            .then(data => setRacingTeams(data))
            .catch(error => {
                console.error(error);
                errorPopup(error);
            });
    }, [insertPressed])

    function loadAllEntries() {
        setIsPending(true);
        getDrivers()
            .then(data => {
                setIsPending(false);
                setDrivers(data);
            })
            .catch(error => {
                console.error(error);
                errorPopup(error);
            });
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
        },
        {
            field: 'points',
            headerName: 'Points',
            type: 'number',
            width: 100,
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
            setCountry("");

            setAlertContent("Entry successfully added");
            setAlertSeverity("success");
            setAlert(true);

            setTimeout(() => {
                setAlert(false);
            }, 4000);
        } else {
            setAlertContent("Please fill out all input fields");
            setAlertSeverity("error");
            setAlert(true);

            setTimeout(() => {
                setAlert(false);
            }, 4000);
        }
    }

    function deleteRow(listOfUuid) {
        for (let i = 0; i < listOfUuid.length; i++) {
            driversUuidDelete(listOfUuid[i])
                .then(() => {
                    loadAllEntries()
                    setAlertContent("Entry successfully deleted");
                    setAlertSeverity("success");
                    setAlert(true);

                    setTimeout(() => {
                        setAlert(false);
                    }, 4000);
                })
                .catch(error => {
                    console.error(error);
                    errorPopup(error);
                });
        }
    }

    function updateRow(id, updatedEntry) {
        let driverData;
        getDriverByUuid(id)
            .then(data => {
                driverData = data
                driverData = {
                    ...driverData,
                    name: updatedEntry.name.value,
                    prename: updatedEntry.prename.value,
                    age: updatedEntry.age.value,
                    country: updatedEntry.country.value,
                    points: updatedEntry.points.value
                }

                updateDriver(driverData, id)
                    .then(data => {
                        driverData = data
                        setAlertContent("Entry successfully updated");
                        setAlertSeverity("success");
                        setAlert(true);

                        setTimeout(() => {
                            setAlert(false);
                        }, 4000);
                    })
                    .catch(error => {
                        console.error(error);
                        errorPopup(error);
                    });
            })
            .catch(error => {
                console.error(error);
                errorPopup(error);
            });
    }

    const handleEditRowsChange = (id) => {
        updateRow(id, editedRow[id]);
    }

    const handleIT = (row) => {
        setEditedRow(row);
    }

    function errorPopup(text) {
        setAlertContent(text);
        setAlertSeverity("error");
        setAlert(true);
    }

    var deleteDisabled = selectedRow.length === 0;
    var detailsDisabled = selectedRow.length !== 1;

    function ButtonRow() {
        return (
            <Row>
                <ButtonGroup>
                    <Button className={"buttonGroup"} onClick={() => setInsertPressed(true)}>Insert</Button>
                    <Button className={"buttonGroup"} onClick={() => deleteRow(selectedRow)}
                            disabled={deleteDisabled}>Delete</Button>
                    <Button className={"buttonGroup"} onClick={() => window.location.href = window.location.href + "/" + selectedRow} disabled={detailsDisabled}>Details</Button>
                </ButtonGroup>
            </Row>
        )
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
                        editMode={"row"}
                        onEditRowsModelChange={e => handleIT(e)}
                        onRowEditCommit={(e) => handleEditRowsChange(e)}
                        onSelectionModelChange={itm => setSelectedRow(itm)}
                    />}
                </Row><br/>
                <ButtonRow/>
                <br/><br/>
                {insertPressed && <Row>
                    <Card sx={{maxWidth: 250}}><br/>
                        <h4>New entry:</h4>
                        <TextField id="standard-basic" label="First name" variant="standard"
                                   onChange={e => setFirstName(e.target.value)} value={firstName}/>
                        <TextField id="standard-basic" label="Last name" variant="standard"
                                   onChange={e => setLastName(e.target.value)}/>
                        <TextField id="standard-basic" label="age" variant="standard" type={"number"}
                                   onChange={e => setAge(e.target.value)}/>
                        <Autocomplete
                            options={data}
                            onChange={(event, value) => setCountry(value?.label)}
                            renderOption={(props, option) => (
                                <Box component="li" sx={{'& > img': {mr: 2, flexShrink: 0}}} {...props}>
                                    <img
                                        loading="lazy"
                                        width="20"
                                        src={`https://flagcdn.com/w20/${option.code.toLowerCase()}.png`}
                                        srcSet={`https://flagcdn.com/w40/${option.code.toLowerCase()}.png 2x`}
                                        alt=""
                                    />
                                    {option.label} ({option.code})
                                </Box>
                            )}
                            renderInput={(params) => <TextField variant={"standard"} {...params} label="Country"/>}
                        />
                        <TextField id="standard-basic" label="Points" variant="standard" type={"number"}
                                   onChange={e => setPoints(e.target.value)}/><br/><br/>
                        <InputLabel variant={"standard"}>Racing Team</InputLabel>
                        <FormControl variant={"standard"} fullWidth>
                            <Select
                                defaultValue={"None"}
                                onChange={e => setSelectedRacingTeam(e.target.value)}>
                                <MenuItem value={"None"}>
                                    None
                                </MenuItem>
                                {racingTeams.map((team, idx) => <MenuItem
                                    key={idx}
                                    value={team}>{team.name}</MenuItem>)}
                            </Select>
                        </FormControl>
                        <br/><br/>
                        <Button onClick={insertEntry} width={"30px"}>Add Entry</Button><br/><br/>
                    </Card>
                </Row>}<br/>
                {alert ? <Alert severity={alertSeverity} onClose={() => setAlert(false)}>{alertContent}</Alert> : <></>}<br/><br/>
            </Container>
        </>
    );
}

export default Drivers;