//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerHeader = styled.header`
    display: flex;
    justify-content: space-between;
    align-items: center;
    ${({ typeHeader }) => {
        const group = { 
            "campus": `
                padding: 10px 60px;
                background-color: var(--fourth-color);
            `,
            "admin": `
                padding: 20px 60px;
                background-color: #ffffff;
                z-index: 1000;
            `
        };
        return group[typeHeader];
    }}
    gap: 10px;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    & > h1 {
        margin: 0;
        width: 25%;
    }
    @media (max-width: 700px) {
        flex-direction: column;
    }
`;
export const TitleNavbar = styled.a`
    display: flex;
    justify-content: space-around;
    align-items: center;
    gap: 30px;
    & img {
        width: 40px;
    }
    & h3 {
        font-weight: normal;
        margin: 0;
    }
`;
