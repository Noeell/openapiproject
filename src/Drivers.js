import {Button, Container, Form, Image, Navbar, Table} from "react-bootstrap";
import Header from "./Header";

function Drivers() {


    return (
        <>
            <Navbar bg="light">
                <Container>
                    <Navbar.Brand>
                        Formel 1
                    </Navbar.Brand>
                    <Navbar.Text>
                        <Header/>
                    </Navbar.Text>
                </Container>
            </Navbar>
            <Container>
                Drivers...
            </Container>
        </>
    );

}

export default Drivers;