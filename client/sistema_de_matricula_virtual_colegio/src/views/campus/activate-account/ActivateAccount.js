// Styles
import { 
    ContainerSectionActivation, 
    Title,
    CardContainer,
    SuccessInfo
} from './styles';
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Components
import SymbolHeader from "../../../components/general/symbolHeader/SymbolHeader";
import CustomButton from '../../../components/general/customButton/CustomButton';
//#endregion

const AccountActivation = () => {
    return (
        <>
        <SymbolHeader/>
        <ContainerSectionActivation>
            <Title className="custom-title-3">¡TE DAMOS LA BIENVENIDA!</Title>
            <CardContainer>
                <div><h5 className="custom-title-6">CUENTA ACTIVADA</h5></div>
                <SuccessInfo>
                    <Icon icon="akar-icons:circle-check-fill"/>
                    <h4 className="custom-title-3">Cuenta creada con éxito</h4>
                    <p>
                        La activación de su cuenta se ha realiza correctamente, desde ahora podrá hacer uso de los servicios que ofrece la institución educativa “Victor Manuel Maurtua”  a través del campus virtual.  Para esto, se le hará entrega del código de estudiante y contraseña enviados al correo electrónico del apoderado.
                    </p>
                    <footer>
                        <CustomButton
                            type="submit"
                            text="OK"/>
                    </footer>
                </SuccessInfo>
            </CardContainer>
        </ContainerSectionActivation>
        </>
        
    );
}

export default AccountActivation;