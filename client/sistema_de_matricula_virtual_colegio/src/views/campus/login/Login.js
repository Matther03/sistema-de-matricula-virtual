//#region Styles
import { 
    ContainerSectionLogin,
    ContentSectionLogin,
    ContentHeaderSectionLogin,
    ContentFormSectionLogin
} from './styles';
//#endregion
//#region Libraries
import {
    TextField, 
    Button 
} from '@mui/material';
//#endregion
//#region Images
import schoolImg from '../../../img/campus/login/school-img.jpg';
//#endregion
//#region Components
import CustomCheckbox from '../../../components/general/CustomCheckbox';
import Navbar from "../../../components/campus/login/navbar/Navbar";
//#endregion

const Login = () => {
    return (
        <>
            <Navbar/>
            <ContainerSectionLogin>
                <img src={schoolImg} alt="escuela, colegio"/>
                <ContentSectionLogin>
                    <ContentHeaderSectionLogin>
                        <h2 className="custom-title-2">INICIAR SESIÓN</h2>
                        <h4 className="custom-title-4">Introduce tu información</h4>
                    </ContentHeaderSectionLogin>
                    <ContentFormSectionLogin action="#">
                        <section className="fields">
                            <TextField 
                                className="custom-input-text"
                                type="text"
                                label="Código de estudiante"
                                variant="filled"/>
                            <TextField 
                                className="custom-input-text"
                                type="password"
                                label="Contraseña"
                                variant="filled"/>
                            <CustomCheckbox 
                                label="Recordarme"/>
                        </section>
                        <footer>
                            <Button 
                                type="submit"
                                className="custom-btn" 
                                variant="contained">Ingresar</Button>
                        </footer>
                    </ContentFormSectionLogin>
                </ContentSectionLogin>
            </ContainerSectionLogin>
        </>
    )
}

export default Login;