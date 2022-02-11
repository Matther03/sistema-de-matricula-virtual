//#region Libraries
import { 
    useEffect 
} from 'react';
import { 
    Routes, 
    Route, 
    Navigate 
} from "react-router-dom";
import { useLocation } from 'react-router';
//#endregion
//#region Components
import SymbolHeader from "../components/general/symbolHeader/SymbolHeader";
import Login from "../views/administrator/login/Login";
import Home from "../views/administrator/home/Home";
import Registration from "../views/administrator/registration/Registration";
//#endregion
//#region Utils
import changeTitle from '../utils/changeTitle.js';
//#endregion

const Administrator = () => { 
    //#region Extra Hooks
    const location = useLocation();
    //#endregion
    //#region Effects
    useEffect(() => {
        changeTitle("Administrador");
    }, []);
    //#endregion
    //#region Functions
    const renderSymbolHeader = () => {
        return (
            !location.pathname.includes("/admin/registro") 
            ? <SymbolHeader typeHeader="admin"/>
            : null
        );
    }
    //#endregion
    return (
        <>
            {renderSymbolHeader()}
            <Routes>
                <Route path="home" element={<Home/>}/>
                <Route path="login" element={<Login/>}/>
                <Route path="registro/*" element={<Registration/>}/>
                <Route 
                    path="*" 
                    element={<Navigate to="/admin/home" replace={true}/>}/>
            </Routes>
        </>
    );
}

export default Administrator;