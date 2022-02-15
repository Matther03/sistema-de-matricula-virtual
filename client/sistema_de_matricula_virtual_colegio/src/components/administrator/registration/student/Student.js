//#region Libraries
import { 
    Routes, 
    Route, 
    Navigate 
} from "react-router-dom";
//#endregion
//#region Styles
import {
    Container 
} from "./styles";
//#endregion
//#region Components
import InternalNav from "../../../general/internalNav/InternalNav";
import StudentRoot from "./studentRoot/StudentRoot";
import NewStudent from "./newStudent/NewStudent";
//#endregion

const informationInternalNav = (() => {
    const root = "/admin/registro/alumno";
    return [
        { path: `/admin/home`, nameRoute: "INICIO" }, 
        { path: `${root}`, nameRoute: "ALUMNO" }, 
        { path: `${root}/nuevo`, nameRoute: "NUEVO" }, 
    ];
})();

const Student = () => {
    return (
        <>
            <InternalNav information={informationInternalNav}/>
            <Container>
                <Routes>
                    <Route
                        path="" 
                        element={<StudentRoot/>}/>
                    <Route
                        path="nuevo" 
                        element={<NewStudent/>}/>
                    <Route
                        path="*"
                        element={
                            <Navigate 
                                to="/admin/registro" 
                                replace={true}/>
                        }/>
                </Routes>
            </Container>
        </>
    );
}

export default Student;