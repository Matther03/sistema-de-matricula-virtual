//#region Styles
import { 
    ContainerHeader, 
    ContainerHeaderUser,
    OffSetHeader } from './styles';
//#endregion
//#region Components
import SymbolHeader from '../../../../general/symbolHeader/SymbolHeader';
import HeaderProfile from '../../../components/headerProfile/HeaderProfile';
//#endregion

const HeaderUser = () => {
    return (
        <header>
            <ContainerHeader>
                <SymbolHeader className="container-symbol-header-enrollment small"/>
                <ContainerHeaderUser>
                    <HeaderProfile className="no-fixed"/>
                </ContainerHeaderUser>
            </ContainerHeader>
            <OffSetHeader/>
        </header>
    );
}


export default HeaderUser;