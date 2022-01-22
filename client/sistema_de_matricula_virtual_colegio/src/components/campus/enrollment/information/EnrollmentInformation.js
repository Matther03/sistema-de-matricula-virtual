import EnrollmentDataInformation from "./enrollmentDataInformation/EnrollmentDataInformation";
import EnrollmentTableInformation from "./enrollmentTableInformation/EnrollmentTableInformation";
import { ContainerEnrollmentInformation } from './styles';

const EnrollmentInformation = () => {
  return (
    <ContainerEnrollmentInformation>
        <EnrollmentDataInformation/>
        <EnrollmentTableInformation/>
    </ContainerEnrollmentInformation>
  );
};

export default EnrollmentInformation;
