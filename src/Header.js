import {Link} from "react-router-dom";

const HeaderLink = ({page, display, selected}) => {
    const title = page.charAt(0).toUpperCase() + page.slice(1);
    return <Link to={`/${page}`} className='headerlink-title'>
        {display || title}
        <div className={selected ? 'headerlink-dot-active' : 'headerlink-dot'}>•</div>
    </Link>;
};

export default function Header(){
    const page = window.location.pathname.replace('/', '') || 'drivers';
    return (
        <div>
            <br/>
            <div className='header'>
                <HeaderLink page='drivers' selected={page === 'drivers'}/>
                <HeaderLink page='teams' selected={page === 'teams'}/>
            </div>
        </div>
    );
};