//#region Libraries
import { useState, useEffect } from "react";
import { useNavigate } from "react-router-dom";
import { InputAdornment, IconButton } from "@mui/material";
//#endregion
//#region Styles
import { ContentFormInfoStudent } from "./styles";
//#endregion
//#region Components
import CustomTextField from "../../../../../general/customTextField/CustomTextField";
import CustomButton from "../../../../../general/customButton/CustomButton";
//#endregion
//#region Utils
import { fieldsHaveErrors } from "../../../../../../utils/validation";
//#endregion

const FormInfoStudent = () => {
	//#region States
	const [form, setForm] = useState({
		dni: "",
		fatherSurname: "",
		name: "",
		motherSurname: "",
		address: "",
		phone: "",
		email: "",
	});
	const [showNoMatchMessageLogin, setShowNoMatchMessageLogin] = useState(false);
	const [errors, setErrors] = useState({
		dni: false,
		fatherSurname: false,
		name: false,
		motherSurname: false,
		address: false,
		phone: false,
		email: false,
	});
	//#endregion
	//#region Functions
	const handleChangeTextField = (e, field) => {
		const { value } = e.target;
		setForm((prev) => ({
			...prev,
			[field]: value,
		}));
		showNoMatchMessageLogin && setShowNoMatchMessageLogin(false);
	};
	//#endregion

	return (
		<ContentFormInfoStudent
		/*onSubmit={handleLogin}*/
		>
			<section className="fields">
				<LoginTextFields
					textFields={{
						dni: {
							type: "text",
							label: "Número de DNI",
							helperText: "Deben haber 8 dígitos numéricos",
							//onKeyPress: handleKeyPressOnlyNumbers,
							length: [8, 8],
						},
						fatherSurname: {
							type: "text",
							label: "Apellido Paterno",
							helperText: "Debe tener 25 caracteres como máximo",
							length: [1, 25],
						},
						name: {
							type: "text",
							label: "Nombres",
							helperText: "Debe tener 50 caracteres como máximo",
							length: [1, 50],
						},
						motherSurname: {
							type: "text",
							label: "Apellido Materno",
							helperText: "Debe tener 25 caracteres como máximo",
							length: [1, 25],
						},
						phone: {
							type: "text",
							label: "Teléfono / Celular",
							helperText: "Debe tener 9 dígitos",
							length: [9, 9],
						},
						email: {
							type: "text",
							label: "Correo electrónico",
							helperText: "Debe tener 50 caracteres como máximo",
							length: [1, 50],
						},
					}}
					handleChangeTextField={handleChangeTextField}
					form={form}
					errors={errors}
				/>
			</section>
			<footer>
				<CustomButton
					className="secondary"
					type="submit"
					disabled={fieldsHaveErrors(errors)}
					text="Guardar"
					/*loading={loadingLoginRequest}*/
				/>
			</footer>
		</ContentFormInfoStudent>
	);
};

const LoginTextFields = ({
	textFields,
	handleChangeTextField,
	form,
	errors,
}) => {
	return (
		<>
			{Object.entries(textFields).map(([key, textField], idx) => (
				<CustomTextField
					key={idx}
					className="registration"
					type={textField.type}
					label={textField.label}
					value={form[key]}
					onChange={(e) => handleChangeTextField(e, key)}
					onKeyPress={textField.onKeyPress && textField.onKeyPress}
					//error={errors[key]}
					//helperText={errors[key] && textField.helperText}
					inputProps={{
						minLength: textField.length[0] && textField.length[0],
						maxLength: textField.length[1] && textField.length[1],
					}}
					InputProps={
						textField.iconEnd && {
							endAdornment: textField.iconEnd,
						}
					}
				/>
			))}
		</>
	);
};

export default FormInfoStudent;
