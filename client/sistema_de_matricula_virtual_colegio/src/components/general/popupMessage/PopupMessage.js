//#region Styles
import { ContainerMessage } from './styles';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
const PopupMessage = (props) => {
    return (
        <ContainerMessage>
            <Icon className={props.className} icon={props.iconName} color={props.color} />
            <h3 className={props.className} color={props.color}>{props.message}</h3>
        </ContainerMessage>
    );
}

export default PopupMessage;