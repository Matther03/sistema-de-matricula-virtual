//#region Styles
import { ContainerDataField, FrameDataField, ContentDataField } from './styles';
//#endregion
//#region mui
import {
    Select,
    MenuItem
} from '@mui/material';
//#endregion
const DataField = () => {
    return (
        <ContainerDataField>
            <FrameDataField>
                <h3>DATOS DEL ALUMNO</h3>
                <ContentDataField>
                    <div>
                        <h4 className="data-type">Código</h4>
                        <h4 className="data-content">20226669</h4>
                    </div>
                    <div className='student-name'>
                        <h4 className="data-type">Alumno</h4>
                        <h4 className="data-content">Salazar Carbajal Yoni Raymundo</h4>
                    </div>
                    <div>
                        <h4 className="data-type">Fecha</h4>
                        <h4 className="data-content">12/04/22</h4>
                    </div>
                </ContentDataField>
                <h3>MATRÍCULA</h3>
                <ContentDataField>
                    <div>
                        <h4 className="data-type">Grado</h4>
                        <h4 className="data-content">1ero Sec</h4>
                    </div>
                    <div className="section-selection">
                        <h4 className="data-type">Sección</h4>
                        <Select className="select-section">
                            <MenuItem value="A">A</MenuItem>
                            <MenuItem value="B">B</MenuItem>
                            <MenuItem value="C">C</MenuItem>
                            <MenuItem value="D">D</MenuItem>
                            <MenuItem value="E">E</MenuItem>
                            <MenuItem value="F">F</MenuItem>
                            <MenuItem value="G">G</MenuItem>
                        </Select>
                    </div>
                    <div>
                        <h4 className="data-type">Turno</h4>
                        <h4 className="data-content">Mañana</h4>
                    </div>
                </ContentDataField>
            </FrameDataField>
        </ContainerDataField>
    )
}

export default DataField;