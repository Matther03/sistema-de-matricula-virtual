//#region Styles
import { ContainerMessage } from './styles';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
const PopupMessage = ({ 
        onClick, 
        className, iconName, 
        color, message
}) => {
    return (
        <ContainerMessage onClick={onClick}>
            <Icon className={className} icon={iconName} color={color} />
            <h3 className={className} color={color}>{message}</h3>
        </ContainerMessage>
    );
}

export default PopupMessage;