//#region Styles
import { 
    ContainerCardLinkServiceCampus, 
    TitleCardLinkServiceCampus
} from './styles';
//#endregion

const CardLinkServiceAdmin = ({ 
    to, 
    text = ""
}) => {
    return (
        <ContainerCardLinkServiceCampus to={`/admin/registro/${to}`}>
            <TitleCardLinkServiceCampus>
                <h4 className="custom-title-4">{text}</h4>
            </TitleCardLinkServiceCampus>
        </ContainerCardLinkServiceCampus>
    );
}

export default CardLinkServiceAdmin;