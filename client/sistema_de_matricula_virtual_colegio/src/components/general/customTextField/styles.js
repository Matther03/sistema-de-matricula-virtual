import {
    TextField
} from '@mui/material';
import styled from "styled-components";

export const StyledTextField = styled(TextField)`
    & input {
        font-size: 18px !important;
    }
    &.admin-input .css-cio0x1-MuiInputBase-root-MuiFilledInput-root {
        border-radius: 10px;
    }
    &.admin-input .css-cio0x1-MuiInputBase-root-MuiFilledInput-root:before {
        visibility: hidden;
    }
    &.admin-input .css-cio0x1-MuiInputBase-root-MuiFilledInput-root:after {
        visibility: hidden;
    }
    &.admin-input input {
        padding: 10px 10px;
        width: 300px;
    }
`;