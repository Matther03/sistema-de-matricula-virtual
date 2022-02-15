//#region Libraries
import { 
    useState,
    useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
//#endregion
//#region Styles
import { 
    ContainerLogoutBtn
} from './styles';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Services
import { logoutAdmin } from '../../../../services/admin/auth';
//#endregion

const LogoutBtn = ({
        className
    }) => {
    //#region Extra hooks
    const navigate = useNavigate();
    //#endregion
    return (
        <ContainerLogoutBtn 
            className={className}
            onClick={() => {
                logoutAdmin();
                navigate("/admin/login");
            }}>
            <Icon icon="ri:logout-box-line"/>
            <span className="custom-title-3">Cerrar sesión</span>
        </ContainerLogoutBtn>
    );
}

export default LogoutBtn;