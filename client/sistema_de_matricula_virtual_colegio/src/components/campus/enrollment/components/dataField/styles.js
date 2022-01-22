//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerDataField = styled.section`
    display: flex;
    padding: 40px 0;
    justify-content: center;
`;
export const FrameDataField = styled.section`
    display: flex;
    flex-direction: column;
    gap: 30px;
    border: 1px solid #737373;
    border-radius: 20px;
    padding: 50px 200px 80px 100px;
    width: 100%;
    & h3 {
        font-weight: 600;
        margin: 0;
        padding: 0;
        font-size: 20px;
    }
    @media (max-width: 1200px) {
        width: 95%
    }
    @media (max-width: 970px) {
        justify-content: center;
    }
    @media (max-width: 850px) {
        padding: 50px 100px 80px 100px;
    }
`
export const ContentDataField = styled.section`
    display: flex;
    justify-content: space-between;
    gap: 100px;
    & div {
        display: flex;
        flex-direction: column;
    }
    & .data-type {
        display: flex;
        justify-content: space-between;
        padding: 0 50px 0 20px;
        font-size: 20px;
        color: #737373;
        font-weight: 400;
        margin: 0;
    }
    & .data-content {
        display: flex;
        justify-content: space-between;
        padding: 0 0 0 40px;
        font-size: 19px;
        font-weight: 400;
        margin: 5px 0 0 0;
    }
    & .student-name {
        padding: 0 0 0 115px;
        @media (max-width: 1200px) {
            padding: 0 0 0 30px;
        }
        @media (max-width: 973px) {
            padding: 0 0 0 50px;
        }
        @media (max-width: 567px) {
            padding: 0 0 0 40px;
        }
    }
    @media (max-width: 973px) {
        display: flex;
        justify-content: center;
        align-items: center;
        gap: 30px;
    }
    @media (max-width: 850px) {
        flex-direction: column;
    }
    & .section-selection {
        padding: 0 0 0 30px;
    }
    & .select-section {
        flex-direction: row;
        width: 150px;
        border-radius: 10px;
        font-size: 20px;
        margin-left: 30px;
    }
    & .css-9ddj71-MuiInputBase-root-MuiOutlinedInput-root.Mui-focused .MuiOutlinedInput-notchedOutline {
        border-color: var(--primary-color);
    }
    & .css-11u53oe-MuiSelect-select-MuiInputBase-input-MuiOutlinedInput-input {
        padding: 5px 0 5px 15px;
    }
`;
