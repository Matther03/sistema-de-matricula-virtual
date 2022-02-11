//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerBackgroundBlue = styled.section`
    position: relative;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    background-color: blue;
    min-height: 100vh;
    background-color: var(--secondary-blue);
    overflow: hidden;
    gap: 15px;
    z-index: 0;
    &::before, &::after {
        content:"";
        position: absolute;
        background-color: #1653B2;
        z-index: -1;
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