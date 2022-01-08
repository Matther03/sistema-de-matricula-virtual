//#region Styles
import './login.css';
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
import CustomCheckbox from '../../../components/general/CustomCheckbox.js';
import Navbar from "../../../components/campus/login/navbar/Navbar.js";
//#endregion

const Login = () => {
    return (
        <>
            <Navbar/>
            <section id="section-login"> {/*ContainerSectionLogin*/}
                <img src={schoolImg} alt="escuela, colegio"/>
                <article className="content">  {/* ContentSectionLogin */}
                    <header> {/* ContentHeaderSectionLogin */}
                        <h2 className="custom-title-2">INICIAR SESIÓN</h2>
                        <h4 className="custom-title-4">Introduce tu información</h4>
                    </header>
                    <form action="#"> {/* ContentFormSectionLogin */}
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
                    </form>
                </article>
            </section>
        </>
    )
}

export default Login;
