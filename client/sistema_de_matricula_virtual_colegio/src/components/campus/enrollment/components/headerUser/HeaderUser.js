import { useState } from 'react';
//#region Styles
import { 
    ContainerHeader, 
    ContainerHeaderUser,
    ContainerProfile,
    LogoutContainer,
    ContainerLogoutBtn,
    OffSetHeader } from './styles';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Components
import SymbolHeader from '../../../components/symbolHeader/SymbolHeader';
//#endregion

const HeaderUser = ({name}) => {
    const [logout, setLogout] = useState(false);

    const showLogout = () => setLogout(prev => (!prev));
    return (
        <header>
            <ContainerHeader>
                <SymbolHeader className="container-symbol-header-enrollment small"/>
                <ContainerHeaderUser>
                    <ContainerProfile onClick={showLogout}>
                        <span className="custom-title-6">{name || "NOMBRE DEL ALUMNO"}</span>
                        <div>
                            <Icon icon="bx:bxs-user"/>
                            <i className={logout 
                                ? "arrow up"
                                : "arrow"}/>
                        </div>
                    </ContainerProfile>
                </ContainerHeaderUser>
            </ContainerHeader>
            <OffSetHeader/>
            {logout 
                && <LogoutContainer>
                    <LogoutButton/>
                </LogoutContainer>}
        </header>
    );
}

const LogoutButton = () => {
    return (
        <>
            <ContainerLogoutBtn>
                <Icon icon="bx:bx-log-out"/>
                <h3 className='custom-title-3'>Cerrar sesión</h3>
            </ContainerLogoutBtn>
        </>
    );
}

export default HeaderUser;