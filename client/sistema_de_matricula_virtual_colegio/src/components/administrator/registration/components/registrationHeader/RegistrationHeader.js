import RegistrationNav from '../registrationNav/RegistrationNav';
import SymbolHeader from "../../../../general/symbolHeader/SymbolHeader";

const RegistrationHeader = () => {
    return (
        <>
            <SymbolHeader typeHeader="admin"/>
            <RegistrationNav/>
        </>
    );
};

export default RegistrationHeader;