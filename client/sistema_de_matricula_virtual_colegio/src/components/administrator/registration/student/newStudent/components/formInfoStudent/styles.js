//#region Libraries
import styled from "styled-components";
//#endregion

export const ContentFormInfoStudent = styled.form`
    display: flex;
    flex-direction: column;
    justify-content: center;
    gap: 25px;
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
export const CustomInputDate = styled.input`
    width: 400px;
    background-color: #f0f0f0;
    border: none;
    border-radius: 4px 4px 0 0;
    font-size: 1rem;
    padding: 17px 12px;
    color: #6D6060;
    cursor: text;
    transition: 0.15s;
    outline: none;
    &:hover {
        background-color: #E8E8E8;
    }
    &::-webkit-calendar-picker-indicator {
        cursor: pointer;
    }
`;