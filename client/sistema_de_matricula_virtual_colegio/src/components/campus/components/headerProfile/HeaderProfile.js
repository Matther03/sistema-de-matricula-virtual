//#region Libraries
import { useState } from 'react';
import { useNavigate } from 'react-router-dom';
//#endregion
//#region Styles
import { 
    ContainerProfile,
    ContentProfile,
    ContainerLogoutBtn } from './styles';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Services
import { logoutStudent } from '../../../../services/auth';
//#endregion

const HeaderProfile = ({ nameUser }) => {
    //#region States
    const [showLogout, setShowLogout] = useState(false);
    //#endregion
    //#region Functions
    const toggleShowLogout = () => setShowLogout(prev => (!prev));
    //#endregion
    return (
        <ContainerProfile onClick={toggleShowLogout}>
            <ContentProfile>
                <span className="custom-title-6">{nameUser || "NOMBRE DEL ALUMNO"}</span>
                <div className="icons">
                    <Icon icon="bx:bxs-user"/>
                    <i className={showLogout 
                        ? "arrow up"
                        : "arrow"}/>
                </div>
            </ContentProfile>
            <LogoutButton className={
                showLogout ? "active" : ""}/>
        </ContainerProfile>
    );
}

const LogoutButton = ({ className }) => {
    //#region Extra hooks
    const navigate = useNavigate();
    //#endregion
    return (
        <ContainerLogoutBtn className={className} onClick={() => {
                logoutStudent();
                navigate("/campus/login");
            }}>
            <Icon icon="bx:bx-log-out"/>
            <span className="custom-title-3">Cerrar sesión</span>
        </ContainerLogoutBtn>
    );
}

export default HeaderProfile;