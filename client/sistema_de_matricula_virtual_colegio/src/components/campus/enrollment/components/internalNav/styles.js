//#region Libraries
import styled from "styled-components";
import { Link } from 'react-router-dom';
//#endregion

export const ContainerNav = styled.nav`
    & ul {
        list-style: none;
        display: flex;
        gap: 10px;
    }
`;
export const LinkNav = styled(Link)`

`;
export const ArrowNav = styled.span`
    color: var(--seventh-color);
    font-weight: bold;
`;