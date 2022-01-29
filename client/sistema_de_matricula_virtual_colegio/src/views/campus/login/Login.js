//#region Libraries
import { 
    useState,
    useEffect
} from 'react';
import { Navigate, useNavigate } from 'react-router-dom';
import {
    Button,
    InputAdornment,
    IconButton
} from '@mui/material';
//#endregion
//#region Styles
import { 
    ContainerSectionLogin,
    ContentSectionLogin,
    ContentHeaderSectionLogin,
    ContentFormSectionLogin
} from './styles';
//#endregion
//#region Images
import schoolImg from '../../../img/campus/login/school-img.jpg';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Components
import CustomCheckbox from '../../../components/general/CustomCheckbox';
import CustomTextField from '../../../components/general/customTextField/CustomTextField';
import SymbolHeader from "../../../components/campus/components/symbolHeader/SymbolHeader";
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
    const [rememberMe, setRememberMe] = useState(true);
    const [showPassword, setShowPassword] = useState(false);
    const [errors, setErrors] = useState({
        dni: false,
        password: false
    });
    //#endregion
    //#region Effects
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
    const handleRememberMe = () => {
        setRememberMe(prev => (!prev));
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
                            <CustomCheckbox 
                                onChange={handleRememberMe}
                                checked={rememberMe}
                                label="Recordarme"/>
                        </section>
                        <footer>
                            <Button 
                                type="submit"
                                className="custom-btn" 
                                disabled={errors.dni || errors.password}
                                variant="contained">Ingresar</Button>
                        </footer>
                    </ContentFormSectionLogin>
                </ContentSectionLogin>
            </ContainerSectionLogin>
        </>
    )
}

export default Login;