//#region Libraries
import { 
    useState 
} from 'react';
//#endregion
//#region Styles
import { 
    ContainerDataField, 
    ContainerEnrollmentData,
    FrameEnrollmentData, 
    ContentEnrollmentData } from './styles';
//#endregion
//#region mui
import {
    Select,
    MenuItem
} from '@mui/material';
//#endregion

const DataField = ({ className, input, description, value }) => {
    return (
        <ContainerDataField className={className}>
            <span className="description">{description}</span>
            {input ? input : <span className="value">{value}</span>}
        </ContainerDataField>
    );
}
const sectionsTest = [
    {codeSection: 1, nameSection: "A"},
    {codeSection: 2, nameSection: "B"},
    {codeSection: 3, nameSection: "C"}
];
const EnrollmentData = ({enrollmentInformation}) => {
    //#region States
    const [codeSection, setCodeSection] = useState(0);
    //#endregion
    //#region Functions
    const getStudentDataDetail = (data) => [
        [
            { description: "Apellidos y Nombres", value: data.fullName },
            { description: "DNI", value: data.dni },
        ]
    ];
    const getEnrollmentDataDetail = (data) => [
        [
            { description: "Grado", value: data.grade },
            { 
                description: "Sección", 
                input: (
                    <Select 
                        value={codeSection} 
                        onChange={(e) => setCodeSection(Number(e.target.value))}
                        className="select-section">
                        <MenuItem value={0} disabled>- SECCIÓN -</MenuItem>
                        {sectionsTest.map((sectionsTest, idx) => (
                            <MenuItem 
                            key={idx} 
                            value={sectionsTest.codeSection}>{sectionsTest.nameSection}</MenuItem>
                        ))}
                    </Select>
                )
            },
            { description: "Turno", value: data.shift }
        ]
    ];
    //#endregion
    return (
        <ContainerEnrollmentData>
            <FrameEnrollmentData>
                <h3>DATOS DEL ALUMNO</h3>
                <ContentEnrollmentData direction="column">
                    {getStudentDataDetail(enrollmentInformation).map((column, idx1) => (
                        <div key={idx1} className="row">
                            {column.map((dataDetail, idx2) => (
                                <DataField
                                    key={idx2}
                                    description={dataDetail.description}
                                    value={dataDetail.value}/>
                            ))}
                        </div>
                    ))}
                </ContentEnrollmentData>
                <h3>MATRÍCULA</h3>
                <ContentEnrollmentData direction="row">
                    {getEnrollmentDataDetail(enrollmentInformation)
                        .map((column, idx1) => (
                        <div key={idx1} className="row">
                            {column.map((dataDetail, idx2) => (
                                <DataField
                                    key={idx2}
                                    description={dataDetail.description}
                                    value={dataDetail.value && dataDetail.value}
                                    input={dataDetail.input && dataDetail.input}/>
                            ))}
                        </div>
                    ))}
                </ContentEnrollmentData>
            </FrameEnrollmentData>
        </ContainerEnrollmentData>
    )
}

export default EnrollmentData;