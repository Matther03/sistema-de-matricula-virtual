//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerProfile = styled.article`
    position: relative;
    & .content {
        display: flex;
        align-items: center;
        padding: 5px 20px;
        gap: 15px;
        cursor: pointer;
        user-select: none;
        transition: 0.25s;
    }
    & .icons {
        display: flex;
        align-items: center;
        cursor: pointer;
        user-select: none;
    }
    & h3 {
        font-weight: normal;
    }
    & .iconify {
        color: var(--fourth-color);
        font-size: 45px;
        cursor: pointer;
    }
    & .arrow {
        width: 0;
        height: 0;
        border-left: 6px solid transparent;
        border-right: 6px solid transparent;
        border-top: 6px solid var(--fourth-color); 
        font-size: 0;
        line-height: 0;
        transition: 0.3s;
    }
    & .up {
        transform: rotate(-180deg);
    }
    & .content:hover {
        background-color: var(--secondary-blue);
    }
`;
export const ContainerLogoutBtn = styled.button`
    display: flex;
    align-items: center;
    justify-content: center;
    gap: 10px;
    background-color: #f8f8f8;
    cursor: pointer;
    gap: 14px;
    user-select: none;
    border: none;
    border-radius: 20px;
    box-shadow: 0px 2px 4px -1px rgb(0 0 0 / 20%), 0px 4px 5px 0px rgb(0 0 0 / 14%), 0px 1px 10px 0px rgb(0 0 0 / 12%);
    transition: 0.25s;
    position: absolute;
    width: 100%;
    padding: 10px;
    top: 110%;
    right: 0;
    visibility: hidden;
    opacity: 0;
    transform: translateY(-100%);
    z-index: -1;
    &:hover {
        background-color: #e3e3e3;
    }
    & .iconify {
        color: #000000;
        font-size: 32px;
    }
    & span {
        font-size: 20px;
    }
    &.active {
        visibility: visible;
        opacity: 1;
        transform: translateY(0);
    }
`;