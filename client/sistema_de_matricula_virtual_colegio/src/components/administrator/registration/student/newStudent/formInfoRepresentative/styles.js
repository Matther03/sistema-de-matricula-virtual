//#region Libraries
import styled, { keyframes } from "styled-components";
//#endregion

export const ContentFormInfoStudent = styled.form`
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 25px;
    width: 64%;

    & .fields {
        display: flex;
        gap: 30px 10px;
        justify-content: center;
        align-items: center;
        flex-wrap: wrap;
    }
    & footer {
        display: flex;
        align-self: flex-end;
        gap: 20px;
    }
    & footer, footer button {
        width: 130px;
    }
`;