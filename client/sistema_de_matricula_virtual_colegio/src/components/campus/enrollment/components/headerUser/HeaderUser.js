//#region Styles
import { 
    ContainerHeader, 
    ContainerHeaderUser,
    ContainerProfile,
    OffSetHeader } from './styles';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Components
import SymbolHeader from '../../../components/symbolHeader/SymbolHeader';
//#endregion

const HeaderUser = () => {
    return (
        <header>
            <ContainerHeader>
                <SymbolHeader className="container-symbol-header-enrollment small"/>
                <ContainerHeaderUser>
                    <h3 className="custom-title-6">INICIO</h3>
                    <ContainerProfile>
                        <div>
                            <h3 className="custom-title-6">NOMBRE DEL ALUMNO</h3>
                        </div>
                        <Icon icon="bx:bxs-user"/>
                    </ContainerProfile>
                </ContainerHeaderUser>
            </ContainerHeader>
            <OffSetHeader/>
        </header>
    );
}

export default HeaderUser;