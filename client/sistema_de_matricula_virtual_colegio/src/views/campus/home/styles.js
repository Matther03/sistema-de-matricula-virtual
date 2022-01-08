//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerSectionHome = styled.section`
    display: flex;
    flex-direction: column;
    justify-content: space-between;
    gap: 10px;
`;
export const HeaderSectionHome = styled.header`
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    background-color: var(--third-color);
    gap: 15px;
    padding: 60px 0;
    & > img {
        width: 90px;
    }
`;
export const ContentSectionHome = styled.article`
    display: flex;
    justify-content: space-evenly;
    flex-wrap: wrap;
    padding: 60px 40px;
    gap: 20px;
`;
