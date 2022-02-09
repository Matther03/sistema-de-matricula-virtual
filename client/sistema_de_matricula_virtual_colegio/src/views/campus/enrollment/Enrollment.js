//#region Libraries
import { 
    Routes, 
    Route 
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

const informationInternalNav = [
    {
        path: "/campus/home", 
        nameItemPath: "INICIO" 
    },
    {
        path: "/campus/matricula", 
        nameItemPath: "MATRÍCULA" 
    },
    {
        path: "/campus/matricula/information", 
        nameItemPath: "INFORMACIÓN" 
    }
];

const Enrollment = () => {
    return (
        <>
            <HeaderUser/>
            <InternalNav 
                information={informationInternalNav}/>
            <Routes>
                <Route
                    path="information" 
                    element={
                        <EnrollmentInformation/>
                    }/>
                <Route
                    path="*"
                    element={<EnrollmentRoot/>}/>
            </Routes>
        </>
    );
}

export default Enrollment;