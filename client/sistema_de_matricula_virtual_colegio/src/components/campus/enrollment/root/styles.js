//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerSectionEnrollment = styled.section`
    display: flex;
    flex-direction: column;
    align-items: center;
    margin: 20px 10px 100px 10px;
    & .ok-btn {
        background-color: var(--seventh-color);
        width: 200px;
        font-size: 24px;
        border-radius: 8px;
    }
    & .ok-btn:hover {
        background-color: var(--seventh-color-dark);
    }
    & .ok-btn:active {
        box-shadow: 0px 2px 4px -1px rgb(0 0 0 / 20%), 0px 4px 5px 0px rgb(0 0 0 / 14%), 0px 1px 10px 0px rgb(0 0 0 / 12%);
    }
    
`;
export const TaskInfo = styled.article`
    padding: 10px;
    width: 70%;

    & p {
        font-size: 22px;
    }
    @media (max-width: 650px) {
        width: 80%;
    }
`