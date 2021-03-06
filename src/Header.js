import {Link} from "react-router-dom";
import {Container, Navbar} from "react-bootstrap";

const HeaderLink = ({page, display, selected}) => {
    const title = page.charAt(0).toUpperCase() + page.slice(1);
    return <Link to={`/${page}`} className='headerlink-title'>
        {display || title}
        <div className={selected ? 'headerlink-dot-active' : 'headerlink-dot'}>•</div>
    </Link>;
};

export default function Header() {
    let page = window.location.href.replace('http://localhost:3000/#/', '');
    if (page === 'http://localhost:3000/') {
        page = 'drivers';
    }
    return (
        <nav className="navbar navbar-dark bg-primary">
            <Container>
                <Navbar.Brand>
                    Formel 1
                </Navbar.Brand>
                <Navbar.Text>
                    <div>
                        <br/>
                        <div className='header'>
                            <HeaderLink page='drivers' selected={page === 'drivers'}/>
                            <HeaderLink page='teams' selected={page === 'teams'}/>
                            <HeaderLink page='tracks' selected={page === 'tracks'}/>
                        </div>
                    </div>
                </Navbar.Text>
            </Container>
        </nav>

    );
};