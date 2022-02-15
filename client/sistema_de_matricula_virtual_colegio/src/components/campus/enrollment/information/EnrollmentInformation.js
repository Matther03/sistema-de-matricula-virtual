//#region Libraries
import { 
    useState,
    useEffect 
} from 'react';
//#endregion
import EnrollmentDataInformation from "./components/enrollmentDataInformation/EnrollmentDataInformation";
import EnrollmentTableInformation from "./components/enrollmentTableInformation/EnrollmentTableInformation";
//#region Styles
import { ContainerEnrollmentInformation } from './styles';
//#endregion

const EnrollmentInformation = () => {
    //#region States
    const [enrollmentInformation, setEnrollmentInformation] = useState({
        grade: "10",
        section: "P",
        shift: "Madrugada",
        dni: "78451263",
        date: "15/02/26"
    });
    //#endregion
    return (
    <ContainerEnrollmentInformation>
        <EnrollmentDataInformation enrollmentInformation={enrollmentInformation}/>
        <EnrollmentTableInformation/>
    </ContainerEnrollmentInformation>
    );
};

export default EnrollmentInformation;
