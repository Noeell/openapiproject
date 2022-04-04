import {Button, Container, Form, Image, Navbar, Table} from "react-bootstrap";
import Header from "./Header";

function Teams() {


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
                Teams...
            </Container>
        </>
    );

}

export default Teams;