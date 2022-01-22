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
import Login from "../views/campus/login/Login";
import Home from "../views/campus/home/Home";
import Matricula from '../views/campus/enrollment/Enrollment';
import Intranet from '../views/campus/intranet/Intranet';
import AulaVirtual from '../views/campus/aula-virtual/AulaVirtual';
//#endregion
//#region Utils
import changeTitle from '../utils/changeTitle.js';
//#endregion

const Campus = () => {
    //#region Effects
    useEffect(() => {
        changeTitle("Campus");
    });
    //#endregion
    return (
        <Routes>
            <Route path="home" element={<Home/>}/>
            <Route path="login" element={<Login/>}/>
            <Route path="matricula" element={<Matricula/>}/>
            <Route path="intranet" element={<Intranet/>}/>
            <Route path="aula-virtual" element={<AulaVirtual/>}/>
            <Route path="*" element={<Login/>}/>
        </Routes>
    );
}

export default Campus;