//#region Libraries
import { useEffect, useState } from "react";
import { useLocation } from 'react-router';
//#endregion
//#region Styles
import {
    ContainerNav, 
    StyledLink 
} from "./styles";
//#endregion

const RegistrationNav = ({ infoRoutes = [] }) => {
    //#region Extra Hooks
    const location = useLocation();
    //#endregion
    //#region States
    const [activeRegistrationLinks, setActiveRegistrationLinks] = useState([]);
    //#endregion
    //#region Effects
    useEffect(() => {
        handlerActiveRegistrationLinks();
    }, [location.pathname]);
    //#endregion
    //#region Functions
    const handlerActiveRegistrationLinks = () => {
        const newActive = infoRoutes
            .map(route => location.pathname
                .includes(`/admin/registro/${route.path}`));
        setActiveRegistrationLinks(newActive);
    }
    //#endregion
    return (
        <ContainerNav>
            <ul>
                {infoRoutes.map((route, idx) => (
                    <li key={idx}>
                        <RegistrationLink 
                            to={route.path}
                            text={route.pathname}
                            active={activeRegistrationLinks[idx]}/>
                    </li>
                ))}
            </ul>
        </ContainerNav>
    );
};

const RegistrationLink = ({ 
        to, text, active = false 
    }) => {
    return (
        <StyledLink 
            to={`/admin/registro/${to}`}
            state={active ? "active" : ""}>{text}</StyledLink>
    );
}

export default RegistrationNav;