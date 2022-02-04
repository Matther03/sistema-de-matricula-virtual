//#region Libraries
import { forwardRef } from 'react';
import {
    Slide 
} from '@mui/material';
//#endregion
//#region Styles
import { 
    ContainerCustomDialogAlert, 
    HeaderCustomDialogAlert,
    FooterCustomDialogAlert
} from './styles';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Components
import CustomButton from '../customButton/CustomButton';
//#endregion

const Transition = forwardRef((props, ref) => {
    return <Slide direction="up" ref={ref} {...props} />;
});

const DialogAlert = ({
        open, 
        handleOpen,
        title, 
        description,
        buttons,
        icons
    }) => {
    const handleClose = () => handleOpen(false);
    return (
        <ContainerCustomDialogAlert 
            open={open}
            TransitionComponent={Transition}
            onClose={handleClose}>
            <HeaderCustomDialogAlert>
                <Icon icon={icons}/*"ci:error-outline"*/ />
                <h3 className="custom-title-2">{title || " TÍTULO"}</h3>
            </HeaderCustomDialogAlert>
            <article className="content-dialog">
                {description || <p>Descripción</p>}
            </article>
            <FooterCustomDialogAlert>
                {buttons.length && buttons.map((ButtonMapping, idx) => <ButtonMapping key={idx}/>)}
            </FooterCustomDialogAlert>
        </ContainerCustomDialogAlert>
    );
}


export default DialogAlert;