//#region Styles
import { 
    Container, Offset 
} from "./styles";
//#endregion
//#region Components
import RegistrationNav from '../registrationNav/RegistrationNav';
import SymbolHeader from "../../../../general/symbolHeader/SymbolHeader";
//#endregion

const RegistrationHeader = ({ infoRoutes }) => {
    return (
        <>
            <Container>
                <SymbolHeader typeHeader="admin" className="no-fixed"/>
                <RegistrationNav infoRoutes={infoRoutes}/>
            </Container>
            <Offset/>
        </>
    );
};

export default RegistrationHeader;