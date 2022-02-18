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
//#region Styles
import { 
    ContentFormInfoStudent,
    CustomInputDate
} from './styles';
//#endregion
//#region Components
import CustomTextField from '../../../../../general/customTextField/CustomTextField';
import CustomButton from '../../../../../general/customButton/CustomButton';
//#endregion
//#region Utils
import { fieldsHaveErrors } from "../../../../../../utils/validate";
//#endregion

const FormInfoStudent = () => {
    //#region States
    const [form, setForm] = useState({
        dni: "",
        fatherSurname: "",
        name: "",
        motherSurname: "",
        address: "",
        dateBirth: ""
    });
    const [showNoMatchMessageLogin, setShowNoMatchMessageLogin] = useState(false);
    const [errors, setErrors] = useState({
        dni: false,
        fatherSurname: false,
        name: false,
        motherSurname: false,
        address: false,
        dateBirth: false
    })
    //#endregion
    //#region Functions
    const handleChangeTextField = (e, field) => {
        const { value } = e.target;
        setForm(prev => ({
            ...prev,
            [field]: value
        }));
        showNoMatchMessageLogin && setShowNoMatchMessageLogin(false);
    }
    const handleDateValue = (e) => {
        console.log(e.target.value)
        const date = new Date(e.target.value.replace(/-/g,"/"));
        //date.setMinutes(date.getMinutes()+date.getTimezoneOffset())
        
        const dateParsed = new Date(date.getTime());
        console.log(dateParsed.getDate()+"/"+dateParsed.getMonth()+"/"+dateParsed.getFullYear());   
        //const year = date.getFullYear();
        //const month = String(date.getMonth()+1).padStart(2,'0');
        //const todayDate = String(date.getDate()).padStart(2,'0');
        //const datePattern = year + '-' + month + '-' + todayDate;
    }
    //#endregion

    return (
        <ContentFormInfoStudent 
            /*onSubmit={handleLogin}*/>
            <section className="fields">
                <LoginTextFields
                    textFields={{
                        "dni": {
                            type: "text", 
                            label: "Número de DNI",
                            helperText: "Deben haber 8 dígitos numéricos",
                            //onKeyPress: handleKeyPressOnlyNumbers,
                            length: [8, 8] 
                        }, 
                        "fatherSurname": {
                            type: "text",
                            label: "Apellido Paterno",
                            helperText: "Debe tener 25 caracteres como máximo",
                            length: [1, 25]
                        },
                        "name": {
                            type: "text",
                            label: "Nombres",
                            helperText: "Debe tener 50 caracteres como máximo",
                            length: [1, 50]
                        },
                        "motherSurname": {
                            type: "text",
                            label: "Apellido Materno",
                            helperText: "Debe tener 25 caracteres como máximo",
                            length: [1, 25]
                        },
                        "address": {
                            type: "text",
                            label: "Dirección",
                            helperText: "Debe tener 50 caracteres como máximo",
                            length: [1, 50] 
                        }
                    }}
                    handleChangeTextField={handleChangeTextField}
                    form={form}
                    errors={errors}/>
                    <CustomInputDate 
                        type="date" 
                        id="date-picker"
                        dateFormat="aaaa-mm-dd" 
                        onChange={(e) => handleDateValue(e)}
                        min="2000-01-01" max="2029-12-31"/>
            </section>
            <footer>
                <CustomButton
                    className="secondary"
                    type="submit"
                    disabled={fieldsHaveErrors(errors)}
                    text="Siguiente"
                    /*loading={loadingLoginRequest}*//>
            </footer>
        </ContentFormInfoStudent>
    );
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
                className="registration"
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

export default FormInfoStudent;