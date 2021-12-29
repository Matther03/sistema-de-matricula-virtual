import '../styles/navbar.css';
import symbolSchoolImg from '../img/school_symbol.png';

const Navbar = () => {
    return (
        <nav id="navbar-main">
            <a class="title">
                <img src={symbolSchoolImg} alt="Insignia"/>
                <h3>I.E.P VICTOR MANUEL MAURTUA - ICA - PERÚ</h3>
            </a>
            <h1>PORTAL</h1>
        </nav>
    );
}

export default Navbar;