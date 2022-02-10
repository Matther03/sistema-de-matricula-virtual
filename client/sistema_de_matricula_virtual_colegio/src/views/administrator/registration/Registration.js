//#region Libraries
import { 
    useState,
    useEffect
} from 'react';
import { 
    Routes, 
    Route, 
    Navigate 
} from "react-router-dom";
//#endregion
//#region Components
import DialogAlert from '../../../components/general/dialogAlert/DialogAlert';
import CustomButton from '../../../components/general/customButton/CustomButton';
import RegistrationHeader from '../../../components/administrator/registration/components/registrationHeader/RegistrationHeader';
import Student from '../../../components/administrator/registration/student/Student';
//#endregion

const Registration = () => {
    return (
        <>
            <RegistrationHeader/>
            <Routes>
                <Route
                    path="alumno" 
                    element={<Student/>}/>
                <Route
                    path="profesor" 
                    element={<h1>Profesor</h1>}/>
                <Route
                    path="curso" 
                    element={<h1>Curso</h1>}/>
                <Route
                    path="*"
                    element={
                        <Navigate 
                            to="/admin/registro/alumno" 
                            replace={true}/>}/>
            </Routes>
            <DialogAlert 
                open={false} 
                title="¡ADVERTENCIA!"
                titleIcon="ant-design:warning-filled"
                buttons={[
                () => (
                        <a 
                            href="https://google.com"
                            target="_blank">
                            <CustomButton
                                variant="outlined"
                                text="SÍ"/>
                        </a>
                    ),
                    () => (
                        <CustomButton
                                variant="outlined"
                                text="NO"/>
                    )
                ]}
                description={
                    <p>¿Está seguro que desea modificar este campo?</p>
                }/>
            <DialogAlert 
                open={false} 
                title="¡ADVERTENCIA!"
                titleIcon="ant-design:warning-filled"
                buttons={[
                    () => <a 
                        href="https://google.com"
                        target="_blank">
                        <CustomButton
                            variant="outlined"
                            text="SÍ"/>
                    </a>,
                    () => <CustomButton
                        variant="outlined"
                        text="NO"/>
                ]}
                description={
                    <p>¿Está seguro que desea guardar un nuevo registro?&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;&emsp;</p>
                }/>
            <DialogAlert 
                open={false} 
                title="AVISO"
                titleIcon="ic:round-notification-important"
                buttons={[
                    () => (
                        <a href="https://google.com"
                            target="_blank">
                            <CustomButton
                                variant="outlined"
                                text="SÍ"/>
                        </a>),
                    () => (
                        <CustomButton
                            variant="outlined"
                            text="NO"/>
                    )
                ]}
                description={
                    <p>¿Está seguro de abandonar esta página? Los datos no se han guardado.&emsp;&emsp;</p>
                }/>
        </>
        
    );
}

export default Registration;