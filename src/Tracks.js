import {useEffect, useState} from "react";
import {addNewTrack, getTrackByUuid, getTracks, tracksUuidDelete, updateTrack} from "./ApiForTracks";
import {Button, Col, Container, Row} from "react-bootstrap";
import {Alert, Autocomplete, Box, ButtonGroup, Card, TextField} from "@mui/material";
import Header from "./Header";
import Loading from "./Loading";
import {DataGrid} from "@mui/x-data-grid";
import {data} from "./Countries";

export default function Tracks() {
    const [tracks, setTracks] = useState([]);
    const [selectedRow, setSelectedRow] = useState([]);
    const [editedRow, setEditedRow] = useState({});
    const [insertPressed, setInsertPressed] = useState();
    const [pageSize, setPageSize] = useState(5);

    const [name, setName] = useState("");
    const [location, setLocation] = useState("");
    const [lenght, setLenght] = useState();
    const [country, setCountry] = useState("");
    const [rounds, setRounds] = useState();

    const [isPending, setIsPending] = useState(true);
    const [alert, setAlert] = useState(false);
    const [alertContent, setAlertContent] = useState('');
    const [alertSeverity, setAlertSeverity] = useState('');

    useEffect(() => {
        loadAllEntries();
    }, [])


    function loadAllEntries() {
        setIsPending(true);
        getTracks()
            .then(data => {
                setIsPending(false);
                setTracks(data);
            })
            .catch(error => {
                console.error(error);
                errorPopup(error);
            });
    }

    const columns = [
        {field: 'uuid', headerName: 'Id', width: 350},
        {field: 'name', headerName: 'Track name', width: 150, editable: true},
        {field: 'location', headerName: 'Location', width: 150, editable: true},
        {
            field: 'lenght',
            headerName: 'Length',
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
            field: 'rounds',
            headerName: 'Rounds',
            type: 'number',
            width: 100,
            editable: true
        }
    ];

    function insertEntry() {
        if (name?.trim() !== "" && location?.trim() !== "" && lenght !== 0 && rounds !== undefined && country?.trim() !== "" && name !== undefined && location !== undefined && country !== undefined) {
            let newTrack = {
                name: name,
                location: location,
                lenght: lenght,
                rounds: rounds,
                country: country,
            }

            addNewTrack(newTrack)
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
            tracksUuidDelete(listOfUuid[i])
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
        let trackData;

        getTrackByUuid(id)
            .then(data => {
                trackData = data
                trackData = {
                    ...trackData,
                    name: updatedEntry.name.value,
                    location: updatedEntry.location.value,
                    lenght: updatedEntry.lenght.value.toString(),
                    country: updatedEntry.country.value,
                    rounds: updatedEntry.rounds.value
                }
                updateTrack(trackData, id)
                    .then(data => {
                        trackData = data
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

    let deleteDisabled = selectedRow.length === 0;

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
                        <h2>Tracks</h2>
                    </Col>
                </Row><br/>{isPending && <Loading/>}
                <Row>
                    {tracks.length > 0 && <DataGrid
                        rows={tracks}
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
                        <TextField id="standard-basic" label="Location" variant="standard"
                                   onChange={e => setLocation(e.target.value)}/>
                        <TextField id="standard-basic" label="Length" variant="standard" type={"number"}
                                   onChange={e => setLenght(e.target.value)}/>
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
                        <TextField id="standard-basic" label="Rounds" variant="standard" type={"number"}
                                   onChange={e => setRounds(e.target.value)}/><br/><br/>
                        <Button onClick={insertEntry} width={"30px"}>Add Entry</Button><br/><br/>
                    </Card>
                </Row>}<br/>
                {alert ? <Alert severity={alertSeverity} onClose={() => setAlert(false)}>{alertContent}</Alert> : <></>}<br/><br/>
            </Container>
        </>
    );
}