//#region Libraries
import { forwardRef } from 'react';
import {
    Slide,
    Button
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

const Transition = forwardRef((props, ref) => {
    return <Slide direction="up" ref={ref} {...props} />;
});

const DialogAlert = ({
        open, 
        handleOpen,
        title, 
        description
    }) => {
    const handleClose = () => handleOpen(false);
    
    return (
        <ContainerCustomDialogAlert 
            open={open}
            TransitionComponent={Transition}
            onClose={handleClose}>
            <HeaderCustomDialogAlert>
                <Icon icon="ci:error-outline" />
                <h3 className="custom-title-2">{title || " TÍTULO"}</h3>
            </HeaderCustomDialogAlert>
            <article className="content-dialog">
                <p>{description || "Descripción"}</p>
            </article>
            <FooterCustomDialogAlert>
                <Button 
                    className="custom-btn secondary"
                    variant="outlined"
                    onClick={handleClose}>CERRAR</Button>
            </FooterCustomDialogAlert>
        </ContainerCustomDialogAlert>
    );
}


export default DialogAlert;