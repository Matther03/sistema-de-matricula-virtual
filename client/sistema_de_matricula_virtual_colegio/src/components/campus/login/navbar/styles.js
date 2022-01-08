//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerNavbar = styled.nav`
    background-color: var(--fourth-color);
    display: flex;
    justify-content: space-around;
    align-items: center;
    padding: 10px;
    gap: 10px;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    & > h1 {
        margin: 0;
    }
    @media (max-width: 700px) {
        flex-direction: column;
    }
`;
export const TitleNavbar = styled.a`
    display: flex;
    justify-content: space-around;
    align-items: center;
    gap: 10px;
    & img {
        width: 60px;
    }
    & h3 {
        font-weight: normal;
        margin: 0;
    }
`;
