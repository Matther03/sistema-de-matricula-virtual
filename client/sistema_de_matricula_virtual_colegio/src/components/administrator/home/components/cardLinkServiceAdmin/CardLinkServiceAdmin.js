//#region Styles
import { 
    ContainerCardLinkServiceCampus, 
    HeaderCardLinkServiceCampus, 
    DescriptionCardLinkServiceCampus
} from './styles';
//#endregion

const CardLinkServiceAdmin = ({ 
    to, 
    title, 
    description, 
    icon 
}) => {
    return (
        <ContainerCardLinkServiceCampus to={to || "./"}>
            <HeaderCardLinkServiceCampus>
                <h4 className="custom-title-4">{title || "Título"}</h4>
            </HeaderCardLinkServiceCampus>
        </ContainerCardLinkServiceCampus>
    );
}

export default CardLinkServiceAdmin;