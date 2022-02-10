//#region Libraries
import { 
    Link 
} from "react-router-dom";
import styled from "styled-components";
//#endregion

export const ContainerNav = styled.nav`
    background-color: var(--fourth-color);
    width: 100%;
    & ul {
        display: flex;
        justify-content: space-around;
        list-style: none;
        margin: 0;
        padding: 0;
    }
    & ul li {
        display: flex;
        width: 100%;
        justify-content: center;
        align-items: center;
    }
`

const activeStyledLink = `
    background-color: var(--seventh-color);
    color: var(--third-color);
`;
export const StyledLink = styled(Link)`
    text-align: center;
    width: 100%;
    padding: 25px 0px;
    text-decoration: none;
    font-weight: bold;
    transition: 0.4s;
    color: var(--fifth-color);
    ${({ state }) => state === "active" ? activeStyledLink : ""}
    &:hover {
        ${activeStyledLink}
    }
`;