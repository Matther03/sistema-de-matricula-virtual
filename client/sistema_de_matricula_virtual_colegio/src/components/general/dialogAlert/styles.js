//#region Libraries
import Dialog  from '@mui/material/Dialog'; 
import styled from "styled-components";
//#endregion

export const ContainerCustomDialogAlert = styled(Dialog)`
    & .MuiPaper-root {
        padding: 10px !important;
        min-width: 300px !important;
        max-width: 500px !important;
    }
`;
export const HeaderCustomDialogAlert = styled.header`
    display: flex;
    gap: 10px;
    align-items: center;
    padding-bottom: 14px;
    border-bottom: 1px solid #d5d5d5;
    & h3 {
        color: var(--seventh-color);
        font-weight: 500;
    }
    & .iconify {
        color: var(--seventh-color);
        font-size: 32px;
    }
`;
export const FooterCustomDialogAlert = styled.footer`
    display: flex;
    gap: 10px;
    justify-content: flex-end;
    align-items: center;
    & a:not(.link-paragraph) {
        text-decoration: none;
    }
    & .MuiButton-outlined {
        border-color: #151515 !important;
        color: #151515 !important;
        border-radius: 15px !important;
    }
`;