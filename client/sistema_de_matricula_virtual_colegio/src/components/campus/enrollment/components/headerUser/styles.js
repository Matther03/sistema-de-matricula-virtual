//#region Libraries
import styled from "styled-components";
//#endregion

export const ContainerHeader = styled.section`
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    z-index: 400;
    & .container-symbol-header-enrollment {
        position: relative !important;
        height: 45px;
        & h3 {
            font-size: 13px;
        }
        & img {
            width: 30px;
        }
    }
`;
export const ContainerHeaderUser = styled.section`
    background-color: var(--secondary-2-color);
    display: flex;
    align-items: center;
    justify-content: right;
    padding: 0 120px;
    & > h3 {
        font-weight: normal;
        font-size: 22px;
    }
    @media (max-width: 900px) {
        padding: 0 40px;
    }
    @media (max-width: 470px) {
        flex-direction: column;
    }
`;
export const ContainerProfile = styled.article`
    display: flex;
    align-items: center;
    padding: 5px 20px;
    gap: 15px;
    cursor: pointer;
    user-select: none;
    transition: 0.25s;
    & div {
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
        float: left;
        transition: 0.3s;
    }
    & .up {
        transform: rotate(-180deg);
    }
    :hover {
        background-color: var(--secondary-blue);
    }
    :active {
        background-color: var(--secondary-blue);
    }
`;
export const OffSetHeader = styled.div`
    height: 120px;
`;
export const LogoutContainer = styled.section`
    display: flex;
    justify-content: right;
    padding: 0 120px;
    width: 100%;
    position: fixed;
    transition: 0.25s;
`;
export const ContainerLogoutBtn = styled.button`
    display: flex;
    align-items: center;
    justify-content: right;
    background-color: #f8f8f8;
    padding: 0 70px;
    cursor: pointer;
    gap: 10px;
    user-select: none;
    border: none;
    border-radius: 20px;
    box-shadow: 0px 2px 4px -1px rgb(0 0 0 / 20%), 0px 4px 5px 0px rgb(0 0 0 / 14%), 0px 1px 10px 0px rgb(0 0 0 / 12%);
    transition: 0.25s;
    :hover {
        background-color: #e3e3e3;
    }
    & .iconify {
        color: #000000;
        font-size: 45px;
    }
    & h3 {
        font-size: 20px;
    }
`;