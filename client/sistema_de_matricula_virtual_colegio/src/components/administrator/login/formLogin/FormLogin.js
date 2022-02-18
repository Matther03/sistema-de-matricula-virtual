//#region Libraries
import { 
    useState,
    useEffect
} from 'react';
import { useNavigate } from 'react-router-dom';
import {
    InputAdornment,
    IconButton
} from '@mui/material';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Styles
import { 
    ContentFormSectionLogin
} from './styles';
//#endregion
//#region Components
import CustomTextField from "../../../general/customTextField/CustomTextField";
import CustomButton from "../../../general/customButton/CustomButton";
//#endregion
//#region Services
import { loginAdmin, isLoggedAdmin } from '../../../../services/admin/auth';
//#endregion
const regex = {
    user: /^.{8,16}$/,
    password: /^.{8,16}$/
}

const FormLogin = () => {
    //#region States
    const [form, setForm] = useState({
        user: "",
        password: ""
    });
    const [showPassword, setShowPassword] = useState(false);
    const [loadingLoginRequest, setLoadingLoginRequest] = useState(false);
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
        <ContentFormSectionLogin
            onSubmit={handleLogin}>
            <section className="fields">
                <LoginTextFields
                textFields={{
                    "user": {
                        type: "text", 
                        label: "Usuario",
                        helperText: "Deben haber 8 dígitos numéricos",
                        length: [8, 8] 
                    }, 
                    "password": {
                        type: showPassword ? "text" : "password",
                        label: "Contraseña",
                        helperText: "Deben haber entre 8 y 16 dígitos y al menos una mayúscula, una minúscula y un dígito numérico",
                        length: [8, 16], 
                        iconEnd: (
                                <InputAdornment position="end">
                                    <IconButton
                                    onClick={toggleShowPassword}>
                                        <Icon icon={showPassword 
                                            ? "ic:sharp-visibility-off"
                                            : "ic:round-visibility"} />
                                    </IconButton>
                                </InputAdornment>
                            )
                    }
                }}
                handleChangeTextField={handleChangeTextField}
                form={form}
                errors={errors}/>
            </section>
            <footer>
                <CustomButton 
                    type="submit"
                    text="INGRESAR"
                    className="secondary"
                    disabled={errors.user || errors.password || loadingLoginRequest}
                    loading={loadingLoginRequest}/>
            </footer>
        </ContentFormSectionLogin>
    )
}

const LoginTextFields = ({ 
    textFields, 
    handleChangeTextField, 
    form,
    errors
}) => {
return (
    <>
        {Object.entries(textFields).map(([key, textField], idx)=> (
            <CustomTextField 
                key={idx}
                type={textField.type}
                label={textField.label}
                value={form[key]}
                onChange={(e) => handleChangeTextField(e, key)}
                onKeyPress={textField.onKeyPress && textField.onKeyPress}
                error={errors[key]}
                helperText={errors[key] && textField.helperText}
                inputProps={{
                    minLength: textField.length[0] && textField.length[0],
                    maxLength: textField.length[1] && textField.length[1]
                }} 
                InputProps={textField.iconEnd && {
                    endAdornment: textField.iconEnd
                }}/>
        ))}
    </>
);
}

export default FormLogin;