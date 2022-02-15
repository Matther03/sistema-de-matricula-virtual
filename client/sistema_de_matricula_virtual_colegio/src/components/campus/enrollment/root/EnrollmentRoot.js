//#region Libraries
import { 
    useState,
    useEffect
} from 'react';
import {
    Button 
} from '@mui/material';
//#endregion
//#region Styles
import { 
    ContainerSectionEnrollment,
    TaskInfo
} from './styles';
//#endregion
//#region Components
import EnrollmentData from './components/enrollmentData/EnrollmentData';
import PopupMessage from '../../../general/popupMessage/PopupMessage';
import CustomDataTable from '../../../general/customDataTable/CustomDataTable';
//#endregion
//#region Services
import { getDetailCampus } from '../../../../services/campus/student';
import { getGradeToEnroll, getDetailClassroom } from '../../../../services/campus/enrollment';
//#endregion

const tableDataVacancies = {
    fields: ["Sección", "Vacantes", "Turno"],
    rows: [
        { section: "A", quantity: 20, shift: "Mañana" }, 
        { section: "B", quantity: 30, shift: "Mañana" }, 
        { section: "C", quantity: 26, shift: "Mañana" },
        { section: "D", quantity: 33, shift: "Tarde" },
        { section: "E", quantity: 40, shift: "Tarde" }
    ] 
}; 

const EnrollmentRoot = () => {
    //#region States
    const [enrollmentInformation, setEnrollmentInformation] = useState({
        dni: "76086866",
        fullName: "Luján Carrión Mayimbú",
        grade: "1ero Sec",
        shift: "Madrugada"
    });
    //#endregion
    //#region Effects
    useEffect(() => {
        fillEnrollmentInformation();
    }, []);
    const fillEnrollmentInformation = async () => {
        const  { _, ...restDetailCampus } = getDetailCampus();
        let objToSet = {
            ...restDetailCampus
        };
        const resGradeToEnroll = await getGradeToEnroll();
        const codeGrade = resGradeToEnroll[0].data.code;
        const resDetailClassroom = await getDetailClassroom(codeGrade);
        console.log(resDetailClassroom);
        objToSet = {
            ...objToSet
        }
        setEnrollmentInformation(objToSet);
    }
    //#endregion
    return (
        <ContainerSectionEnrollment>
            <TaskInfo>
                <h3 className="custom-title-2">MATRÍCULA</h3>
                <p>
                    Rellene el siguiente formulario con los datos solicitados para realizar la matrícula. Recuerde que solo se puede realizar una vez, por lo tanto no se puede modificar.
                </p>
            </TaskInfo>
            <EnrollmentData enrollmentInformation={enrollmentInformation}/>
            <PopupMessage 
                color="var(--verification)"
                message="La matrícula se ha realizado correctamente" 
                iconName="bi:check-circle-fill"/>
            <PopupMessage 
                color="var(--seventh-color)"
                message="Error, debes seleccionar la sección" 
                iconName="clarity:error-line"/>
            <Button 
                type="submit"
                className="ok-btn" 
                variant="contained">OK</Button>
            <PopupMessage 
                className="register"
                message="Ver registro de matrícula" 
                iconName="el:eye-open"/>
            <CustomDataTable 
                rows={tableDataVacancies.rows}
                fields={tableDataVacancies.fields}
                width="70%"/>
        </ContainerSectionEnrollment>
    );
}

export default EnrollmentRoot;