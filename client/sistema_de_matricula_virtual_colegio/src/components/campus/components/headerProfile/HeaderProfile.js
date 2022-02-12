//#region Libraries
import { 
    useState,
    useEffect 
} from 'react';
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

const HeaderProfile = ({ only = false }) => {
    //#region States
    const [nameUser, setNameUser] = useState("");
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
        <ContainerProfile onClick={toggleShowLogout}>
            <ContentProfile className={only && "only"}>
                <span className="custom-title-6">{nameUser}</span>
                <div className="icons">
                    <Icon icon="bx:bxs-user"/>
                    <Icon 
                        className={`arrow ${showLogout ? "up" : ""}`}
                        icon="bx:bxs-down-arrow"/>
                </div>
            </ContentProfile>
            <LogoutButton active={showLogout}/>
        </ContainerProfile>
    );
}

const LogoutButton = ({ active = false }) => {
    //#region Extra hooks
    const navigate = useNavigate();
    //#endregion
    return (
        <ContainerLogoutBtn className={active && "active"} onClick={() => {
                logoutStudent();
                navigate("/campus/login");
            }}>
            <Icon icon="bx:bx-log-out"/>
            <span className="custom-title-3">Cerrar sesión</span>
        </ContainerLogoutBtn>
    );
}

export default HeaderProfile;