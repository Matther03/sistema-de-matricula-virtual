// Styles
import { ContainerNavbar, TitleNavbar } from './StylesNavbar';
// Images
import symbolSchoolImg from '../../img/school_symbol.png';

const Navbar = () => {
    return (
        <ContainerNavbar>
            <TitleNavbar>
                <img src={symbolSchoolImg} alt="Insignia"/>
                <h3 className="custom-title-4">
                    I.E. VICTOR MANUEL MAURTUA - ICA - PERÚ
                </h3>
            </TitleNavbar>
            <h1 className="custom-title-1">CAMPUS</h1>
        </ContainerNavbar>
    );
}

export default Navbar;