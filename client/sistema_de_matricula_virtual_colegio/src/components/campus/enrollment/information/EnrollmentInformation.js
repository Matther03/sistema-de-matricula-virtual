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
//#region Utils
import { getDate } from '../../../../utils/date';
//#endregion
//#region Services
import { getDetailCampus } from '../../../../services/campus/student';
import { getDetailEnrollment } from '../../../../services/campus/enrollment';
//#endregion

const EnrollmentInformation = ({ enrolled }) => {
    //#region States
    const [information, setInformation] = useState({
        fullName: "-", 
        grade: "-",
        section: "-",
        shift: "-",
        dni: "-",
        date: "-"
    });
    //#endregion
    //#region Effects
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
        enrolled && fillInformation();
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
