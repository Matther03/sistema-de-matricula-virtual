//#region Libraries
import { 
    useState,
    useEffect 
} from 'react';
import {
    Navigate 
} from "react-router-dom";
//#endregion
//#region Styles
import { ContainerEnrollmentInformation } from './styles';
//#endregion
//#region Components
import EnrollmentDataInformation from "./components/enrollmentDataInformation/EnrollmentDataInformation";
import EnrollmentTableInformation from "./components/enrollmentTableInformation/EnrollmentTableInformation";
//#region Services
import { getDetailCampus } from '../../../../services/campus/student';
import { getDetailEnrollment } from '../../../../services/campus/enrollment';
//#endregion

const EnrollmentInformation = ({ enrolled }) => {
    //#region States
    const [information, setInformation] = useState({
        fullName: "", 
        grade: "PRIMERO",
        section: "Z",
        shift: "MADRUGADA",
        dni: "",
        date: "12/12/2012"
    });
    //#endregion
    //#region Effects
    const getDate = (data) => {
        const date = new Date(data);
        return `${date.getDate()}/${date.getMonth()}/${date.getFullYear()}`;
    }
    const fillInformation = async () => {
        const { codeStudent, dni, fullName } = getDetailCampus();
        const [payload, err] =  await getDetailEnrollment(codeStudent);
        if (!payload.data || err) return;
        const { data } = payload;
        setInformation(prev => ({
            ...prev, 
            fullName, 
            dni,
            date: getDate(data.date),
            grade: data.classroom.grade.name, 
            section: data.classroom.section.letter, 
            shift: data.classroom.section.shift.category
        }));
    };
    useEffect(() => {
        fillInformation();
    }, []);
    if (!enrolled) 
        return (<Navigate to="/campus/matricula/" replace={true}/>);
    //#endregion
    return (
        <ContainerEnrollmentInformation>
            <EnrollmentDataInformation enrollmentInformation={information}/>
            <EnrollmentTableInformation/>
        </ContainerEnrollmentInformation>
    );
};

export default EnrollmentInformation;
