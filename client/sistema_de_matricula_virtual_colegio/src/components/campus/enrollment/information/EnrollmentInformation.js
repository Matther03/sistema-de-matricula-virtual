//#region Libraries
import { 
  useEffect 
} from 'react';
//#endregion
import EnrollmentDataInformation from "./enrollmentDataInformation/EnrollmentDataInformation";
import EnrollmentTableInformation from "./enrollmentTableInformation/EnrollmentTableInformation";
import { ContainerEnrollmentInformation } from './styles';

const EnrollmentInformation = () => {
    //#region States
    //#endregion
    //#region Effects
    //#endregion
    return (
    <ContainerEnrollmentInformation>
        <EnrollmentDataInformation/>
        <EnrollmentTableInformation/>
    </ContainerEnrollmentInformation>
    );
};

export default EnrollmentInformation;
