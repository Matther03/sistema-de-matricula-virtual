//#region Styles
import { 
    ContainerSectionEnrollment,
    TaskInfo
} from './styles';
//#endregion
//#region Components
import Header from '../components/header/Header';
import DataField from '../components/dataField/DataField';
import PopupMessage from '../../../general/popupMessage/PopupMessage';
//#endregion
//#region mui
import {
    Button 
} from '@mui/material';
//#endregion
const EnrollmentRoot = () => {
    return (
        <>
            <Header/>
            <ContainerSectionEnrollment>
                <TaskInfo>
                    <h3>MATRÍCULA</h3>
                    <p>
                        Rellene el siguiente formulario con los datos solicitados para realizar la matrícula. Recuerde que solo se puede realizar una vez, por lo tanto no se puede modificar.
                    </p>
                </TaskInfo>
                <DataField></DataField>
                <PopupMessage 
                    color="var(--verification)"
                    message="La matrícula se ha realizado correctamente" 
                    iconName="bi:check-circle-fill"></PopupMessage>
                <PopupMessage 
                    color="var(--seventh-color)"
                    message="Error, debes seleccionar la sección" 
                    iconName="clarity:error-line"></PopupMessage>
                <Button 
                    type="submit"
                    className="ok-btn" 
                    variant="contained">OK</Button>
                <PopupMessage 
                    className="register"
                    message="Ver registro de matrícula" 
                    iconName="el:eye-open"></PopupMessage>
            </ContainerSectionEnrollment>
        </>
    );
}

export default EnrollmentRoot;