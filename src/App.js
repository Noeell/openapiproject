import {Button, Container, Form, Image, Navbar, Table} from "react-bootstrap";
import logo from './logo.png'

function App() {
    return (
        <>
            <Navbar bg="light">
                <Container>
                    <Navbar.Brand>
                        <Image src={logo} alt="" width={48} height={48} />{' '}
                        Formel 1
                    </Navbar.Brand>
                    <Navbar.Text>
                        <a href="http://localhost:8080/api/swagger-ui/index.html">API {">>"}</a>
                    </Navbar.Text>
                </Container>
            </Navbar>
            <Container>
                Drivers...
            </Container>
        </>
    );
}

export default App;
