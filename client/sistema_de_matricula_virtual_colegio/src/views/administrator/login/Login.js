//#region libraries
import { 
    useState,
    useEffect
} from 'react';
import { Link, Navigate, useNavigate } from 'react-router-dom';
import {
    InputLabel,
    Button,
    InputAdornment,
    IconButton
} from '@mui/material';
//#endregion
//#region Styles
import { 
    ContainerSectionLogin,
    ContentSectionLogin,
    AdminImgContainer,
    ContentFormSectionLogin
} from './styles';
//#endregion
//#region Images
import adminImg from '../../../img/administrator/login/admin-icon.png';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Components
import SymbolHeader from "../../../components/campus/components/symbolHeader/SymbolHeader";
import CustomTextField from '../../../components/general/customTextField/CustomTextField';
//#endregion
//#region Services
import { loginAdmin, isLoggedAdmin } from '../../../services/auth';
//#endregion
const regex = {
    user: /^[0-9]{8}$/,
    password: /^.{8,16}$/
}

const Login = () => {
    //#region States
    const [form, setForm] = useState({
        user: "",
        password: ""
    });
    const [showPassword, setShowPassword] = useState(false);
    const [errors, setErrors] = useState({
        user: false,
        password: false
    });
    //#endregion
    //#region Effects
    useEffect(() => {
        validateField("user");
    }, [form.user]);
    useEffect(() => {
        validateField("password");
    }, [form.password]);
    //#endregion
    //#region Extra hooks
    const navigate = useNavigate();
    //#endregion
    //#region Functions
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
        loginAdmin({ 
            user: form.user, 
            password: form.password 
        });
        isLoggedAdmin() && navigate("/admin/home");
    }
    //#endregion
    return (
        <>
            {isLoggedAdmin() && <Navigate to="../home" replace={true}/>}
            <SymbolHeader className="adminHeader"/>
            <ContainerSectionLogin>
                <ContentSectionLogin>
                    <AdminImgContainer>
                        <img src={adminImg} alt="Icono Admin"/>
                    </AdminImgContainer>
                    <h2 className="custom-title-2">INICIAR SESIÓN</h2>
                    <ContentFormSectionLogin
                        onSubmit={handleLogin}>
                        <section className="fields">
                            <div>
                                <InputLabel className="admin-input-label">Usuario</InputLabel>
                                <CustomTextField 
                                        className="admin-input"
                                        variant="outlined"
                                        value={form.user}
                                        onChange={(e) => handleChangeTextField(e, "user")}
                                        error={errors.user}
                                        />
                            </div>
                            <div>
                                <InputLabel className="admin-input-label">Contraseña</InputLabel>
                                <CustomTextField 
                                    type={showPassword ? "text" : "password"}
                                    value={form.password}
                                    onChange={(e) => handleChangeTextField(e, "password")}
                                    error={errors.password}
                                    InputProps={{ 
                                        endAdornment: (
                                            <InputAdornment >
                                                <IconButton
                                                onClick={toggleShowPassword}>
                                                    <Icon icon={showPassword 
                                                        ? "ic:sharp-visibility-off"
                                                        : "ic:round-visibility"} />
                                                </IconButton>
                                            </InputAdornment>
                                        )
                                    }}/>
                            </div>
                        </section>
                        <footer>
                        <Button 
                            className="login-btn"
                            type="submit"
                            disabled={errors.user || errors.password}>Ingresar</Button>
                        </footer>
                    </ContentFormSectionLogin>
                </ContentSectionLogin>
            </ContainerSectionLogin>
        </>
    );
}

export default Login;