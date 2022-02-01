//#region Libraries
import { 
    useState,
    useEffect
} from 'react';
import { Link, Navigate, useNavigate } from 'react-router-dom';
import {
    InputAdornment,
    IconButton
} from '@mui/material';
//#endregion
//#region Styles
import { 
    ContainerSectionLogin,
    ContentSectionLogin,
    ContentHeaderSectionLogin,
    ContentFormSectionLogin,
    IsNewStudent
} from './styles';
//#endregion
//#region Images
import schoolImg from '../../../img/campus/login/school-img.jpg';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Components
import DialogAlert from '../../../components/general/dialogAlert/DialogAlert';
import CustomTextField from '../../../components/general/customTextField/CustomTextField';
import CustomButton from '../../../components/general/customButton/CustomButton';
import SymbolHeader from "../../../components/general/symbolHeader/SymbolHeader";
//#endregion
//#region Services
import { loginStudent, isLoggedStudent } from '../../../services/auth';
//#endregion

const regex = {
    dni: /^[0-9]{8}$/,
    password: /^.{8,16}$/
}

const Login = () => {
    //#region States
    const [form, setForm] = useState({
        dni: "",
        password: ""
    });
    const [showPassword, setShowPassword] = useState(false);
    const [errors, setErrors] = useState({
        dni: false,
        password: false
    });
    const [showDialogRememberRegister, setShowDialogRememberRegister] = useState(false);
    //#endregion
    //#region Effects
    useEffect(() => {
        if (localStorage.getItem("alreadyRememberRegister"))
            return;
        setShowDialogRememberRegister(true);
        localStorage.setItem("alreadyRememberRegister", "true");
    }, []);
    useEffect(() => {
        validateField("dni");
    }, [form.dni]);
    useEffect(() => {
        validateField("password");
    }, [form.password]);
    //#endregion
    //#region Extra hooks
    const navigate = useNavigate();
    //#endregion
    //#region Functions
    const handleKeyPressOnlyNumbers = (e) => {
        if (!/^[0-9]$/.test(e.key))
            e.preventDefault();
    }
    const handleChangeTextField = (e, field) => {
        const { value } = e.target;
        setForm(prev => ({
            ...prev,
            [field]: value
        }));
    }
    const toggleShowPassword = () => {
        setShowPassword(prev => (!prev));
    }
    const validateField = (field) => {
        setErrors(prev => ({
            ...prev,
            [field]: !regex[field].test(form[field])
        }));
    }
    const handleLogin = (e) => {
        e.preventDefault();
        loginStudent({ 
            dni: form.dni, 
            password: form.password 
        });
        isLoggedStudent() && navigate("/campus/home");
    }
    const handleShowDialogRememberRegister = () => {
        setShowDialogRememberRegister(prev => !prev);
    }
    //#endregion
    return (
        <>
            {isLoggedStudent() && <Navigate to="../home" replace={true}/>}
            <SymbolHeader showTitle={true}/>
            <ContainerSectionLogin>
                <img src={schoolImg} alt="escuela, colegio"/>
                <ContentSectionLogin>
                    <ContentHeaderSectionLogin>
                        <h2 className="custom-title-2">INICIAR SESIÓN</h2>
                        <h4 className="custom-title-4">Introduce tu información</h4>
                    </ContentHeaderSectionLogin>
                    <ContentFormSectionLogin 
                        onSubmit={handleLogin}>
                        <section className="fields">
                            <CustomTextField 
                                type="text"
                                label="Número de DNI"
                                value={form.dni}
                                onChange={(e) => handleChangeTextField(e, "dni")}
                                onKeyPress={handleKeyPressOnlyNumbers}
                                // onFocus={() => resetError("dni")}
                                error={errors.dni}
                                helperText={errors.dni && "Deben haber 8 dígitos"}
                                inputProps={{
                                    maxLength: 8
                                }}/>
                            <CustomTextField 
                                type={showPassword ? "text" : "password"}
                                label="Contraseña"
                                value={form.password}
                                onChange={(e) => handleChangeTextField(e, "password")}
                                // onFocus={() => resetError("password")}
                                error={errors.password}
                                helperText={errors.password && "Deben haber 16 dígitos"}
                                inputProps={{
                                    minLength: 8, 
                                    maxLength: 16
                                }}
                                InputProps={{ 
                                    endAdornment: (
                                        <InputAdornment position="end">
                                          <IconButton
                                            onClick={toggleShowPassword}>
                                                <Icon icon={showPassword 
                                                    ? "ic:sharp-visibility-off"
                                                    : "ic:round-visibility"} />
                                          </IconButton>
                                        </InputAdornment>
                                      )
                                }}/>
                        </section>
                        <footer>
                            <CustomButton
                                type="submit"
                                disabled={errors.dni || errors.password}
                                text="Ingresar"/>
                            <IsNewStudent>
                                <span className="description">¿Eres nuevo?</span>
                                <span 
                                    className="open-dialog"
                                    onClick={handleShowDialogRememberRegister}>Presiona aquí</span>
                            </IsNewStudent>
                        </footer>
                    </ContentFormSectionLogin>
                </ContentSectionLogin>
            </ContainerSectionLogin>
            <DialogAlert 
                open={showDialogRememberRegister} 
                handleOpen={handleShowDialogRememberRegister}
                title="¡RECUERDA!"
                buttons={[
                    () => <a 
                        href="https://google.com"
                        target="_blank">
                        <CustomButton
                            variant="outlined"
                            text="VER MÁS"/>
                    </a>,
                    () => <CustomButton
                        variant="outlined"
                        onClick={() => setShowDialogRememberRegister(false)}
                        text="Cerrar"/>
                ]}
                description={
                    <ul>
                        <li>Para poder iniciar sesión debes haber presentado los documentos solicitados  en la instución.</li>
                        <li>Se te asiganará un código de estudiante y contraseña que serán enviados a tu correo electrónico. </li>
                        <li>Con los datos generados ya podrás iniciar sesión.</li>
                    </ul>
                }/>
        </>
    )
}

export default Login;