import CustomDataTable from '../../../../general/customDataTable/CustomDataTable';

const createRandomData = (quantityRows) => {
    const randomData = [];
    const courses = ["Matemática", "Comunicación", "Inglés", "Personal Social"];
    const teachers = ["Joaquín Ramirez", "Roberto Rodriguez", "Rebecca Lopez"];
    for (let i = 0; i < quantityRows; i++) 
        randomData.push( {
            numero: (i + 1),
            course: courses[parseInt(Math.random()*courses.length)],
            shift: teachers[parseInt(Math.random()*teachers.length)]
        });
    return randomData;
}
const tableData = {
    caption: <><span>TUTOR A CARGO:</span> {"Mario Castañeda"}</>,
    fields: ["N°", "Curso", "Docente"],
    rows: createRandomData(5)
};

const EnrollmentTableInformation = () => {
    return (
        <CustomDataTable 
            rows={tableData.rows} 
            fields={tableData.fields}
            caption={tableData.caption}
            width="70%"/>
    );
}

export default EnrollmentTableInformation;