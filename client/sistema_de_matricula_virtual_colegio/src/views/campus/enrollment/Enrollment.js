//#region Libraries
import {
    useState, 
    useEffect 
} from "react";
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
import DialogAlertRedirectToHome from '../../../components/campus/enrollment/components/dialogAlertRedirectToHome/DialogAlertRedirectToHome';
//#endregion
//#region Services
import { canEnroll } from "../../../services/campus/enrollment";
//#endregion

const informationInternalNav = (() => {
    const root = "/campus/matricula"
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
            path: `${root}/informacion`, 
            nameRoute: "INFORMACIÓN" 
        }
    ];
})();


const enrollResponse = {
    CAN_ENROLL: "CAN_ENROLL",
    COMPLETED_STUDIES: "COMPLETED_STUDIES",
    ENROLLED: "ENROLLED",
    NO_PAID: "NO_PAID",
    ERROR: "ERROR"
}

const Enrollment = () => {
    const [didMount, setDidMount] = useState(false);
    const [stateEnroll, setStateEnroll] = useState("");
    //#region Effects
    useEffect(() => {
        setDidMount(true);
        return () => setDidMount(false);
     }, [])
    useEffect(() => {
        manageCanEnroll();
    }, []);
    //#endregion
    //#region Functions
    const manageCanEnroll = async () => {
        const [payload, err] = await canEnroll();
        if (!payload.data || err) {
            setStateEnroll(enrollResponse.ERROR);
            return;
        }
        setStateEnroll(payload.data.stateEnroll);
    } 
    //#endregion
    if (!didMount) return null;
    if (stateEnroll === enrollResponse.ERROR)
        return (
            <DialogAlertRedirectToHome 
                title="ERROR INESPERADO" 
                description="Ha ocurrido un error inesperado. Inténtelo más tarde."/>
        );
    if (stateEnroll === "") 
        return null;
    if (stateEnroll === enrollResponse.COMPLETED_STUDIES)
        return (
            <DialogAlertRedirectToHome 
                title="INFORMACIÓN" 
                description="Usted ya completó sus estudios satisfactoriamente."/>
            );
    if (stateEnroll === enrollResponse.ENROLLED)
        return (<Navigate to="/campus/matricula/informacion" replace={true}/>);
    if (stateEnroll === enrollResponse.NO_PAID)
        return (
            <DialogAlertRedirectToHome 
                title="PAGO NO REALIZADO" 
                description="Debe realizar el pago correspondiente para poder matricularse."/>
        );
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