//#region Libraries
import styled from "styled-components";
//#endregion
export const ContainerLogoutBtn = styled.button`
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;
    background-color: transparent;
    cursor: pointer;
    gap: 14px;
    user-select: none;
    border: none;
    border-radius: 14px;
    transition: 0.4s;
    padding: 10px 22px;
    z-index: -1;
    
    &:hover {
        background-color: var(--secondary-2-color);
    }
    & .iconify {
        color: var(--fourth-color);
        font-size: 32px;
    }
    & span {
        font-size: 20px;
        color: var(--fourth-color);
    }
`;