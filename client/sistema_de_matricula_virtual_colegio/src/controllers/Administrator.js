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

export const infoRoutes = [
    { path: "alumno", nameRoute: "ALUMNO" }, 
    { path: "profesor", nameRoute: "PROFESOR" }, 
    { path: "curso", nameRoute: "CURSO" } 
];

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
            && <SymbolHeader className="admin"/>
        );
    }
    //#endregion
    return (
        <>
            {renderSymbolHeader()}
            <Routes>
                <Route path="home" element={
                        <Home infoRoutes={infoRoutes}/>
                    }/>
                <Route path="login" element={<Login/>}/>
                <Route path="registro/*" element={
                        <Registration infoRoutes={infoRoutes}/>
                    }/>
                <Route 
                    path="*" 
                    element={<Navigate to="/admin/home" replace={true}/>}/>
            </Routes>
        </>
    );
}

export default Administrator;