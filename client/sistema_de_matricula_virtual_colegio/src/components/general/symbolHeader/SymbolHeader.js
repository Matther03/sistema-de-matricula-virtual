//#region Styles
import { ContainerHeader, TitleNavbar } from './styles';
//#endregion
//#region Images
import symbolSchoolImg from '../../../img/general/school-symbol.png';
//#endregion

const SymbolHeader = ({ 
        typeHeader = "campus", 
        showTitle,
        className }) => {
    return (
        <ContainerHeader 
            className={className}
            typeHeader={typeHeader} showTitle={showTitle}>
            <TitleNavbar>
                <img src={symbolSchoolImg} alt="Insignia"/>
                <h3 className="custom-title-4">
                    I.E. VICTOR MANUEL MAURTUA - ICA - PERÚ
                </h3>
            </TitleNavbar>
            {showTitle 
                ? <h1 className="custom-title-1">CAMPUS</h1>
                : <span></span>}
        </ContainerHeader>
    );
}

export default SymbolHeader;