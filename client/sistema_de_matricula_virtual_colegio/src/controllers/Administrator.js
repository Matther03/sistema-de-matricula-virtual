//#region Libraries
import { 
    useEffect 
} from 'react';
import { 
    Routes, 
    Route 
} from "react-router-dom";
//#endregion
//#region Components
import Home from "../views/administrator/home/Home";
//#endregion
//#region Utils
import changeTitle from '../utils/changeTitle.js';
//#endregion

const Administrator = () => {
    //#region Effects
    useEffect(() => {
        changeTitle("Administrador");
    });
    //#endregion
    return (
        <Routes>
            <Route path="home" element={<Home/>}/>
            <Route path="*" element={<Home/>}/>
        </Routes>
    );
}

export default Administrator;