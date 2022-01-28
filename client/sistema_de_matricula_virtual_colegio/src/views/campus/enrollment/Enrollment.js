//#region Libraries
import { 
    useState, 
    useEffect 
} from 'react';
import { useLocation } from 'react-router';
import { 
    Routes, 
    Route 
} from "react-router-dom";
//#endregion
//#region Components
import HeaderUser from '../../../components/campus/enrollment/components/headerUser/HeaderUser';
import InternalNav from '../../../components/campus/enrollment/components/internalNav/InternalNav';
import EnrollmentInformation from '../../../components/campus/enrollment/information/EnrollmentInformation';
import EnrollmentRoot from '../../../components/campus/enrollment/root/EnrollmentRoot';
//#endregion
//#region Utils
//#endregion

const Enrollment = () => {
    //#region States
    const [paths, setPaths] = useState(["../home", "../matricula", "./information"]);
    //#endregion
    //#region Extra Hooks
    const location = useLocation();
    //#endregion
    //#region Effects
    useEffect(() => {
        setPaths((prev) => {
            const { pathname } = location;
            const equalsWithSlash = (areEquals) => 
                    (areEquals || 
                    (areEquals && pathname.endsWith('/')));
            if (equalsWithSlash(pathname === "/campus/matricula"))
                return ["../home", "./"];
            if (equalsWithSlash(pathname === "/campus/matricula/information"))
                return ["../home", "../matricula", "./information"];
            return prev;
        });    
    },[location.pathname]);
    //#endregion
    //#region Functions
    //#endregion
    return (
        <>
            <HeaderUser name="LUJÁN CARRIÓN, MAYIMBÚ"/>
            <InternalNav paths={paths}/>
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