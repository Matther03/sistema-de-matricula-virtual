//#region Libraries
import { 
    useState,
    useEffect
} from 'react';
import {
    TextField, 
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
import Navbar from "../../../components/campus/login/navbar/Navbar";
//#endregion

const regex = {
    dni: /^[0-9]{8}$/,
    password: /^.{8,16}$/
}

const Login = () => {
    //#region States
    const [student, setStudent] = useState({
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
    //#endregion
    //#region Functions
    const handleKeyPressOnlyNumbers = (e) => {
        if (!/^[0-9]$/.test(e.key))
            e.preventDefault();
    }
    const handleChangeTextField = (e, field) => {
        const { value } = e.target;
        setStudent(prev => ({
            ...prev,
            [field]: value
        }))
    }
    const resetError = (field) => {
        setErrors(prev => ({
            ...prev,
            [field]: false
        }));
    }
    const toggleShowPassword = () => {
        setShowPassword(prev => (!prev));
    }
    const handleRememberMe = () => {
        setRememberMe(prev => (!prev));
    }
    const handleLogin = (e) => {
        e.preventDefault();
        setErrors(prev => ({
            dni: !regex.dni.test(student.dni),
            password: !regex.dni.test(student.password)
        }));
    }
    //#endregion
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
                    <ContentFormSectionLogin 
                        onSubmit={handleLogin}>
                        <section className="fields">
                            <TextField 
                                className="custom-input-text"
                                type="text"
                                label="Número de DNI"
                                value={student.dni}
                                onChange={(e) => handleChangeTextField(e, "dni")}
                                onKeyPress={handleKeyPressOnlyNumbers}
                                onFocus={() => resetError("dni")}
                                variant="filled"
                                error={errors.dni}
                                helperText={errors.dni && "Deben haber 8 dígitos"}
                                inputProps={{
                                    maxLength: 8
                                }}/>
                            <TextField 
                                className="custom-input-text"
                                type={showPassword ? "text" : "password"}
                                label="Contraseña"
                                value={student.password}
                                onChange={(e) => handleChangeTextField(e, "password")}
                                onFocus={() => resetError("password")}
                                variant="filled"
                                error={errors.password}
                                helperText={errors.password && "Deben haber 16 dígitos"}
                                inputProps={{
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
                                variant="contained">Ingresar</Button>
                        </footer>
                    </ContentFormSectionLogin>
                </ContentSectionLogin>
            </ContainerSectionLogin>
        </>
    )
}

export default Login;