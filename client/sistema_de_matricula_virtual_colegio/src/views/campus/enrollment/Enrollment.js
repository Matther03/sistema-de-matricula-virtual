import InternalNav from '../../../components/campus/enrollment/components/internalNav/InternalNav';
import EnrollmentInformation from '../../../components/campus/enrollment/information/EnrollmentInformation';

const Enrollment = () => {
    return (
        <div>
            <InternalNav/>
            <h1>Matrícula</h1>
            <EnrollmentInformation/>
        </div>
    );
}

export default Enrollment;