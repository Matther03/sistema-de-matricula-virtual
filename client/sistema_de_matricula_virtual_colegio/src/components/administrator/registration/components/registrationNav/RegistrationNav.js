//#region Libraries
import { 
    Link 
} from "react-router-dom";
//#endregion

const RegistrationNav = () => {
    return (
        <nav>
            <ul>
                <li>
                    <RegistrationLink 
                        to="/alumno"
                        text="ALUMNO"/>
                </li>
                <li>
                    <RegistrationLink 
                        to="/profesor"
                        text="PROFESOR"/>
                </li>
                <li>
                    <RegistrationLink 
                        to="/curso"
                        text="CURSO"/>
                </li>
            </ul>
        </nav>
    );
};

const RegistrationLink = ({ to, text }) => {
    return (
        <Link to={`/admin/registro${to}`}>{text}</Link>
    );
}

export default RegistrationNav;