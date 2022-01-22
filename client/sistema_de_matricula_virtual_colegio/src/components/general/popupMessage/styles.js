//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerMessage = styled.section`
    display: flex;
    align-items: center;
    gap: 10px;
    & h3 {
        margin: 0;
        padding: 0;
        font-weight: 400;
        font-size: 20px;
    }
    & .iconify{
        font-size: 45px;
    }
    & .register {
        cursor: pointer;
    }
`;