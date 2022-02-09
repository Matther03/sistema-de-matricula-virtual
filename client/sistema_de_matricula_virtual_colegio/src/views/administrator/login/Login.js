//#region Libraries
import { Navigate } from 'react-router-dom';
//#endregion
//#region Styles
import { 
    ContainerSectionLogin,
    ContentSectionLogin,
    AdminImgContainer,
} from './styles';
//#endregion
//#region Images
import adminImg from '../../../img/administrator/login/admin-icon.png';
//#endregion

//#region Components
import SymbolHeader from "../../../components/general/symbolHeader/SymbolHeader";
import FormLogin from "../../../components/administrator/login/formLogin/FormLogin";
//#endregion
//#region Services
import { isLoggedAdmin } from '../../../services/admin/auth';
//#endregion

const Login = () => {
    return (
        <>
            {isLoggedAdmin() && <Navigate to="/admin/home" replace={true}/>}
            <ContainerSectionLogin>
                <ContentSectionLogin>
                    <AdminImgContainer>
                        <img src={adminImg} alt="Icono Admin"/>
                    </AdminImgContainer>
                    <h2 className="custom-title-2">INICIAR SESIÓN</h2>
                    <FormLogin/>
                </ContentSectionLogin>
            </ContainerSectionLogin>
        </>
    );
}

export default Login;