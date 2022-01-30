//#region Styles
import { 
    ContainerHeader, 
    ContainerHeaderUser,
    OffSetHeader } from './styles';
//#endregion
//#region Components
import SymbolHeader from '../../../components/symbolHeader/SymbolHeader';
import HeaderProfile from '../../../components/headerProfile/HeaderProfile';
//#endregion

const HeaderUser = ({ nameUser }) => {
    return (
        <header>
            <ContainerHeader>
                <SymbolHeader className="container-symbol-header-enrollment small"/>
                <ContainerHeaderUser>
                    <HeaderProfile nameUser={nameUser}/>
                </ContainerHeaderUser>
            </ContainerHeader>
            <OffSetHeader/>
        </header>
    );
}


export default HeaderUser;