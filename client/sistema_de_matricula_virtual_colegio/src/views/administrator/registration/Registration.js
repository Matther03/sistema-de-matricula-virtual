//#region Libraries
import { 
    useState,
    useEffect
} from 'react';
//#endregion
//#region Components
import DialogAlert from '../../../components/general/dialogAlert/DialogAlert';
import CustomTextField from '../../../components/general/customTextField/CustomTextField';
import CustomButton from '../../../components/general/customButton/CustomButton';
import SymbolHeader from "../../../components/general/symbolHeader/SymbolHeader";
//#endregion

const Registration = () => {
    return (
        <>
            <SymbolHeader typeHeader="admin"/>
            <div>
                <h1>Principal Alumno</h1>
            </div>
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