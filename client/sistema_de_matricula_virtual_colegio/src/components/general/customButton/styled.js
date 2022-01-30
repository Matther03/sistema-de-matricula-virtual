//#region Libraries
import {
    Button 
} from '@mui/material';
import styled from "styled-components";
//#endregion

export const StyledButton = styled(Button)`
    padding: 5px 30px !important;
    border: 0;
    &.MuiButton-contained {
        border-radius: 5px;
        background-color: var(--primary-color) !important;
    }
    &:disabled {
        color: #b5b5b5 !important;
        background-color: #353535 !important;
    }
    &.secondary {
        border-color: var(--primary-color) !important;
        background-color: var(--third-color) !important;
        color: var(--primary-color) !important;
    }
    &.secondary:hover {
        background-color: var(--primary-color) !important;
        color: var(--third-color) !important;
    }
`;