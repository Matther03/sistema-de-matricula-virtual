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
    justify-content: space-between;
    align-items: center;
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
    gap: 15px;
    & div {
        background-color: var(--seventh-color);
        padding: 5px 18px;
        cursor: pointer;
        user-select: none;
    }
    & h3 {
        font-weight: normal;
    }
    & .iconify{
        color: var(--fourth-color);
        font-size: 45px;
        cursor: pointer;
    }
`;
export const OffSetHeader = styled.div`
    height: 120px;
`;