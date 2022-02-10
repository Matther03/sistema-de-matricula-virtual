//#region Libraries
import { 
    useState,
    useEffect } from 'react';
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
import { logoutStudent } from '../../../../services/campus/auth';
import { getDetailCampus } from '../../../../services/campus/student';
//#endregion

const HeaderProfile = ({ className }) => {
    //#region States
    const [nameUser, setNameUser] = useState("NOMBRE DEL ALUMNO");
    const [showLogout, setShowLogout] = useState(false);
    //#endregion
    //#region Effects
    useEffect(() => {
        const { fullName } = getDetailCampus();
        setNameUser(fullName);
    }, []);
    //#endregion
    //#region Functions
    const toggleShowLogout = () => setShowLogout(prev => (!prev));
    //#endregion
    return (
        <ContainerProfile className={className} onClick={toggleShowLogout}>
            <ContentProfile>
                <span className="custom-title-6">{nameUser}</span>
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