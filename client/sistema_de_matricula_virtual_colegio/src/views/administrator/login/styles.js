//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerSectionLogin = styled.section`
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: blue;
    min-height: 100vh;
    margin-top: 81px;
    background-color: var(--secondary-blue);
    
`;
export const ContentSectionLogin = styled.article`
    display:flex;
    flex-direction: column;
    position: relative;
    z-index: 0;
    background-color: var(--third-color);
    padding: 40px;
    border-radius: 30px;
    justify-content: center;
    align-items: center;
    & h2 {
        margin: 65px 0 30px 0;
    }
`;
export const AdminImgContainer = styled.div`
    position: absolute;
    top: -18%;
    left: 50%;
    transform: translateX(-50%);
    background-color: var(--fourth-color);
    border-radius: 50%;
    padding: 25px;
    box-shadow: 5px 5px 10px 0px #00000040;
    & img {
        width: 100px;
    }
`
export const ContentFormSectionLogin = styled.form`
    display: flex;
    flex-direction: column;
    align-items: center;
    gap: 50px;
    width: 100%;
    & .fields {
        display: flex;
        flex-direction: column;
        gap: 15px;
        width: 100%;
    }
`