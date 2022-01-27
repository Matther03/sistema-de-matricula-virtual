//#region Libraries
// import { 
//   useEffect 
// } from 'react';
//#endregion
import EnrollmentDataInformation from "./enrollmentDataInformation/EnrollmentDataInformation";
import EnrollmentTableInformation from "./enrollmentTableInformation/EnrollmentTableInformation";
//#region Styles
import { ContainerEnrollmentInformation } from './styles';
//#endregion

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
