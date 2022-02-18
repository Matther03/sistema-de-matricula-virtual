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

const getTeacherFullName = (teacher) => `${teacher.fatherSurname} ${teacher.motherSurname}, ${teacher.name}`;


const EnrollmentInformation = ({ enrolled }) => {
    //#region States
    const [dataInformation, setDataInformation] = useState({
        fullName: "-", 
        grade: "-",
        section: "-",
        shift: "-",
        dni: "-",
        date: "-"
    });
    const [tableInformation, setTableInformation] = useState([]);
    //#endregion
    //#region Effects
        useEffect(() => {
        enrolled && doGetDetailEnrollment();
    }, []);
    //#endregion
    //#region Functions
    const doGetDetailEnrollment = async () => {
        const { codeStudent, ...restDetailCampus } = getDetailCampus();
        const [payload, err] =  await getDetailEnrollment(codeStudent);
        if (!payload.data || err) return;
        const { 
            detailEnrollment, 
            classroomTeachers, 
            teacher } = payload.data;
        fillInformation(restDetailCampus, detailEnrollment);
        fillTableData(teacher, classroomTeachers);
    }
    const fillInformation = (detailCampus, detailEnrollment) => {
        setDataInformation(prev => ({
            ...prev, 
            ...detailCampus, 
            date: getDate(detailEnrollment.date),
            grade: detailEnrollment.classroom.grade.name, 
            section: detailEnrollment.classroom.section.letter, 
            shift: detailEnrollment.classroom.section.shift.category
        }));
    };
    const fillTableData = (formTeacher, classroomTeachers) => {
        setTableInformation({
            formTeacher: getTeacherFullName(formTeacher),
            courses: classroomTeachers.map(
                (classroomTeacher, idx) => ({
                    numberIdx: idx + 1,
                    course: classroomTeacher.course.name,
                    teacher: getTeacherFullName(classroomTeacher.teacher)
                }))
        });
    }
    //#endregion
    if (!enrolled) 
        return (<Navigate to="/campus/matricula/" replace={true}/>);
    return (
        <ContainerEnrollmentInformation>
            <EnrollmentDataInformation 
                dataInformation={dataInformation}/>
            <EnrollmentTableInformation 
                tableInformation={tableInformation}/>
        </ContainerEnrollmentInformation>
    );
};

export default EnrollmentInformation;
