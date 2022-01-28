//#region Libraries
import { 
    useState 
} from 'react';
//#endregion
//#region Styles
import { 
    ContainerDataField, 
    ContainerDataEnrollment,
    FrameDataEnrollment, 
    ContentDataEnrollment } from './styles';
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
const DataEnrollment = () => {
    //#region States
    const [section, setSection] = useState(0);
    //#endregion
    return (
        <ContainerDataEnrollment>
            <FrameDataEnrollment>
                <h3>DATOS DEL ALUMNO</h3>
                <ContentDataEnrollment>
                    <DataField 
                        description="DNI" value="70290308"/>
                    <DataField 
                        className="student-name" 
                        description="Alumno" 
                        value="Salazar Carbajal Yoni Raymundo"/>
                </ContentDataEnrollment>
                <h3>MATRÍCULA</h3>
                <ContentDataEnrollment>
                    <DataField 
                        description="Grado" value="1ero Sec"/>
                    <DataField 
                        description="Sección" input={
                            <Select 
                                value={section} 
                                onChange={(e) => setSection(Number(e.target.value))}
                                className="select-section">
                                <MenuItem value={0} disabled>- SECCIÓN -</MenuItem>
                                <MenuItem value={1}>A</MenuItem>
                                <MenuItem value={2}>B</MenuItem>
                                <MenuItem value={3}>C</MenuItem>
                                <MenuItem value={4}>D</MenuItem>
                                <MenuItem value={5}>E</MenuItem>
                            </Select>
                        }/>
                    <DataField 
                        description="Turno" value="Mañana"/>
                </ContentDataEnrollment>
            </FrameDataEnrollment>
        </ContainerDataEnrollment>
    )
}

export default DataEnrollment;