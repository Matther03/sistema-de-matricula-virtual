import { 
    TableContainer, 
    TableCell, 
    TableRow } from '@mui/material';
import styled from "styled-components";

export const StyledContainerTable = styled(TableContainer)`
    padding: 10px;
    width: ${(props) => (props.width)} !important;
`;
export const StyledCaptionTable = styled.caption`
    caption-side: top !important;
    background-color: var(--fourth-color);
    font-size: 16px !important;
    & span {
        font-weight: bold;
    }
`;
export const StyledTableRow = styled(TableRow)`
    &:nth-of-type(odd) {
        background-color: #ebebeb;
    }
    &:last-child td, &:last-child th {
        border: 0;
    }
`;
export const StyledTableCell = styled(TableCell)`
    text-align: center;
    &.MuiTableCell-head {
        background-color: var(--secondary-2-color);
        color: #ffffff;
    }
    &.MuiTableCell-body {
        font-size: 14
    }
`;