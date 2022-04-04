import {Button, Col, Container, Navbar, Row} from "react-bootstrap";
import Header from "./Header";
import {DataGrid} from '@mui/x-data-grid';
import {driversUuidDelete, getDrivers, getDriverByUuid} from "./ApiForDrivers";
import {useEffect, useState} from "react";

function Drivers() {
    const [drivers, setDrivers] = useState([]);
    const [selectedRow, setSelectedRow] = useState();
    const [editedCell, setEditedCell] = useState();

    useEffect(() => {
        loadAllEntries()
    }, [])

    function loadAllEntries() {
        getDrivers()
            .then(data => setDrivers(data))
            .catch(error => console.error(error));
    }

    console.log(drivers);
    const columns = [
        {field: 'uuid', headerName: 'Id', width: 350},
        {field: 'name', headerName: 'First name', width: 150, editable: true},
        {field: 'prename', headerName: 'Last name', width: 150, editable: true},
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

    function deleteRow(listOfUuid) {
        for (let i = 0; i < listOfUuid.length; i++) {
            driversUuidDelete(listOfUuid[i])
                .then(loadAllEntries)
                .catch(error => console.error(error));
        }
    }

    function updateRow(){
        let driverData;
        console.log(selectedRow)
        getDriverByUuid(selectedRow)
            .then(data => driverData = data)
            .catch(error => console.error(error));

        console.log(driverData)
    }
    return (
        <>
            <Header/>
            <Container>
                <Row>
                    <Col>
                        <h2>Drivers</h2>
                    </Col>
                </Row><br/>
                <Row>
                    <DataGrid
                        rows={drivers}
                        columns={columns}
                        rowsPerPageOptions={[5, 10, 20]}
                        checkboxSelection
                        autoHeight
                        autoWidth
                        getRowId={row => row.uuid}
                        onSelectionModelChange={itm => setSelectedRow(itm)}
                        onEditRowsModelChange={dd => setEditedCell(dd)}
                    />
                </Row><br/>
                <Row>
                    <Col>
                        <Button>Insert</Button>
                    </Col>
                    <Col>
                        <Button onClick={updateRow}>Update</Button>
                    </Col>
                    <Col>
                        <Button onClick={() => deleteRow(selectedRow)}>Delete</Button>
                    </Col>
                </Row>

            </Container>
        </>
    );

}

export default Drivers;