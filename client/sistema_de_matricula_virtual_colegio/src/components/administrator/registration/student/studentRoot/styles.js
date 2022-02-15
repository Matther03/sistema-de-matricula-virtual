import styled from "styled-components";

export const Container = styled.section`
    margin: 0 30px;
    width: 80%;
`;
export const Title = styled.h1`
    font-size: 18px;
`;
export const DetailRow = styled.span`
    color: var(--secondary-blue);
    text-decoration: underline;
    font-weight: bold;
    font-size: 16px;
    transition: 0.35s;
    cursor: pointer;
    &:hover {
        filter: brightness(130%);        
    }
`;