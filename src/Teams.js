import {Button, Col, Container, Row} from "react-bootstrap";
import Header from "./Header";
import {useEffect, useState} from "react";
import {addRacingTeam, deleteRacingTeam, getRacingTeamById, getRacingTeams, updateRacingTeam} from "./ApiForDrivers";
import {Alert, Autocomplete, Box, ButtonGroup, Card, TextField} from "@mui/material";
import Loading from "./Loading";
import {DataGrid} from "@mui/x-data-grid";
import {data} from "./Countries";

function Teams() {

    const [racingTeams, setRacingTeams] = useState([]);
    const [selectedRow, setSelectedRow] = useState([]);
    const [editedRow, setEditedRow] = useState({});
    const [insertPressed, setInsertPressed] = useState();
    const [pageSize, setPageSize] = useState(5);

    const [name, setName] = useState("");
    const [teamBoss, setTeamBoss] = useState("");
    const [engineProducer, setEngineProducer] = useState("");
    const [country, setCountry] = useState("");
    const [points, setPoints] = useState();

    const [isPending, setIsPending] = useState(true);
    const [alert, setAlert] = useState(false);
    const [alertContent, setAlertContent] = useState('');
    const [alertSeverity, setAlertSeverity] = useState('');

    useEffect(() => {
        loadAllEntries();
    }, [])

    function loadAllEntries() {
        setIsPending(true);
        getRacingTeams()
            .then(data => {
                setIsPending(false);
                setRacingTeams(data);
            })
            .catch(error => {
                console.error(error);
                errorPopup(error);
            });
    }

    const columns = [
        {field: 'uuid', headerName: 'Id', width: 350},
        {field: 'name', headerName: 'Team-Name', width: 150, editable: true},
        {
            field: 'teamBoss',
            headerName: 'Team Boss',
            width: 150,
            editable: true
        },
        {field: 'engineProducer', headerName: 'Engine Producer', width: 150, editable: true},
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
        if (name?.trim() !== "" && teamBoss?.trim() !== "" && engineProducer?.trim() !== "" && country?.trim() !== "" && name !== undefined && teamBoss !== undefined && country !== undefined && engineProducer !== undefined) {
            let newRacingTeam = {
                name: name,
                teamBoss: teamBoss,
                engineProducer: engineProducer,
                points: points,
                country: country
            }

            addRacingTeam(newRacingTeam)
                .catch(error => console.error(error))
                .finally(loadAllEntries);
            setInsertPressed(false);
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
            deleteRacingTeam(listOfUuid[i])
                .then(() => {
                    loadAllEntries();
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
        let racingTeamData;
        getRacingTeamById(id)
            .then(data => {
                racingTeamData = data
                racingTeamData = {
                    ...racingTeamData,
                    name: updatedEntry.name.value,
                    teamBoss: updatedEntry.teamBoss.value,
                    engineProducer: updatedEntry.engineProducer.value,
                    country: updatedEntry.country.value,
                    points: updatedEntry.points.value
                }

                updateRacingTeam(racingTeamData, id)
                    .then(data => {
                        racingTeamData = data
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

    function ButtonRow() {
        return (
            <Row>
                <ButtonGroup>
                    <Button className={"buttonGroup"} onClick={() => setInsertPressed(true)}>Insert</Button>
                    <Button className={"buttonGroup"} onClick={() => deleteRow(selectedRow)}
                            disabled={deleteDisabled}>Delete</Button>
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
                        <h2>Teams</h2>
                    </Col>
                </Row><br/>{isPending && <Loading/>}
                <Row>
                    {racingTeams.length > 0 && <DataGrid
                        rows={racingTeams}
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
                        <TextField id="standard-basic" label="Name" variant="standard"
                                   onChange={e => setName(e.target.value)}/>
                        <TextField id="standard-basic" label="Team Boss" variant="standard"
                                   onChange={e => setTeamBoss(e.target.value)}/>
                        <TextField id="standard-basic" label="Engine Producer" variant="standard"
                                   onChange={e => setEngineProducer(e.target.value)}/>
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
                        <Button onClick={insertEntry} width={"30px"}>Add Entry</Button><br/><br/>
                    </Card>
                </Row>}<br/>
                {alert ? <Alert severity={alertSeverity} onClose={() => setAlert(false)}>{alertContent}</Alert> : <></>}<br/><br/>
            </Container>
        </>
    );
}

export default Teams;