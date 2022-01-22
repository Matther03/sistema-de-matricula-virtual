//#region Styles
import { ContainerHeader, ContainerProfile } from './styles';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
const Header = () => {
    return (
        <ContainerHeader>
            <h3 className="custom-title-6">INICIO</h3>
            <ContainerProfile>
                <div>
                   <h3 className="custom-title-6">NOMBRE DEL ALUMNO</h3>
                </div>
                <Icon icon="bx:bxs-user"/>
            </ContainerProfile>
        </ContainerHeader>
    );
}

export default Header;