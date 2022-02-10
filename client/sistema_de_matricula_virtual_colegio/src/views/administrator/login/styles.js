//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerSectionLogin = styled.section`
    position: relative;
    display: flex;
    justify-content: center;
    align-items: center;
    background-color: blue;
    min-height: 100vh;
    background-color: var(--secondary-blue);
    overflow: hidden;
    &::before, &::after {
        content:"";
        position: absolute;
        background-color: #1653B2;
    }
    &::before{
        top: 0;
        left: -10vw;
        height: 30vw;
        width: 30vw;
        transform: rotate(45deg)
    }
    &::after{
        bottom: -10vw;
        right: -10vw;
        height: 35vw;
        width: 35vw;
        border-radius: 50%;
    }
`;
export const ContentSectionLogin = styled.article`
    display: flex;
    flex-direction: column;
    position: relative;
    z-index: 1;
    background-color: var(--third-color);
    padding: 40px;
    border-radius: 30px;
    justify-content: center;
    align-items: center;
    width: 440px;
    margin-top: 35vh;
    margin-bottom: 15vh;
    @media (max-width: 800px) { width: 70%}
    @media (max-width: 600px) { width: 90%; }
    & h2 {
        margin-top: 55px;
        margin-bottom: 30px;
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
`;
