//#region Libraries
import styled from "styled-components";
import { Link } from 'react-router-dom';
//#endregion

export const ContainerCardLinkServiceCampus = styled(Link)`
    text-decoration: none !important;
    display: flex;
    flex-direction: column;
    align-items: center;
    background-color: #C5D7F1;
    padding: 10px;
    width: 250px;
    border-radius: 26px;
    box-shadow: inset 0 2px 2px 0 #00000077;
    transition: 0.4s;
    &:hover {
        transform: scale(1.05);
        background-color: #ADC3E3;
        box-shadow: inset 5px 5px 10px #00000077;
        h4 {
            font-weight: 700;
        }
    }
`;
export const TitleCardLinkServiceCampus = styled.article`
    display: flex;
    align-items: center;
    gap: 10px;
    & h4 {
        color: #000000;
        font-size: 32px;    
        font-weight: 600;
    }
`;