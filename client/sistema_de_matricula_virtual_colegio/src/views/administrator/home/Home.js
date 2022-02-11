//#region Styles
import {
    ContainerBackgroundBlue,
} from '../../../components/administrator/components/styles';
import {
    ContainerLinks,
    Title,
    Content,
    Divider
} from './styles';
//#endregion
//#region Components
import LogoutBtn from "../../../components/administrator/home/components/logoutBtn/LogoutBtn";
import CardLinkServiceAdmin from "../../../components/administrator/home/components/cardLinkServiceAdmin/CardLinkServiceAdmin";
//#endregion

const Home = () => {
    return (
        <ContainerBackgroundBlue>
            <LogoutBtn/>
            <Divider/>
            <Content>
                <Title className="custom-title-6">BIENVENIDO AL ADMINISTRADOR</Title>
                <ContainerLinks>
                    <CardLinkServiceAdmin
                        title="Alumno"/>
                    <CardLinkServiceAdmin
                        title="Profesor"/>
                    <CardLinkServiceAdmin
                        title="Curso"/>
                </ContainerLinks>
            </Content>
        </ContainerBackgroundBlue>
    );
}

export default Home;