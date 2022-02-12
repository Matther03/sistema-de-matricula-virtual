//#region Libraries
import { 
    Routes, 
    Route, 
    Navigate
} from "react-router-dom";
//#endregion
//#region Components
import HeaderUser from '../../../components/campus/enrollment/components/headerUser/HeaderUser';
import InternalNav from '../../../components/general/internalNav/InternalNav';
import EnrollmentInformation from '../../../components/campus/enrollment/information/EnrollmentInformation';
import EnrollmentRoot from '../../../components/campus/enrollment/root/EnrollmentRoot';
//#endregion
//#region Utils
//#endregion

const informationInternalNav = (() => {
    const root = "/campus/matricula/"
    return [
        {
            path: "/campus/home", 
            nameRoute: "INICIO" 
        },
        {
            path: root, 
            nameRoute: "MATRÍCULA" 
        },
        {
            path: `${root}informacion`, 
            nameRoute: "INFORMACIÓN" 
        }
    ];
})();

const Enrollment = () => {
    return (
        <>
            <HeaderUser/>
            <InternalNav 
                information={informationInternalNav}/>
            <Routes>
                <Route
                    path="informacion" 
                    element={
                        <EnrollmentInformation/>
                    }/>
                <Route
                    path="" 
                    element={
                        <EnrollmentRoot/>
                    }/>
                <Route
                    path="*"
                    element={<Navigate to="/campus/matricula" replace={true}/>}/>
            </Routes>
        </>
    );
}

export default Enrollment;