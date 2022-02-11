//#region Styles
import { 
    ContainerCardLinkServiceCampus, 
    TitleCardLinkServiceCampus
} from './styles';
//#endregion

const CardLinkServiceAdmin = ({ 
    to, 
    title, 
}) => {
    return (
        <ContainerCardLinkServiceCampus to={to || "./"}>
            <TitleCardLinkServiceCampus>
                <h4 className="custom-title-4">{title || "Título"}</h4>
            </TitleCardLinkServiceCampus>
        </ContainerCardLinkServiceCampus>
    );
}

export default CardLinkServiceAdmin;