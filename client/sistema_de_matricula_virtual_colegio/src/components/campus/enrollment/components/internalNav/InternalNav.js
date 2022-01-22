import { ContainerNav, NavLink, ArrowNav } from './styles';

const InternalNav = ({ paths }) => {
    return (
        <ContainerNav>
            <ul>
                <InternalNavLink 
                    text="INICIO"
                    to={paths[0]}
                    end={!paths[1]}/>
                {paths[1] && 
                    <InternalNavLink 
                        text="MATRÍCULA"
                        to={paths[1]}
                        end={!paths[2]}/>}
                 {paths[2] && 
                    <InternalNavLink 
                        text="INFORMACIÓN"
                        to={paths[2]}
                        end={true}/>}
            </ul>
        </ContainerNav>
    );
}

const InternalNavLink = ({ text, to, end }) => {
    return (
        <>
            <li><NavLink to={to}>{text}</NavLink></li>
            {!end && <ArrowNav>{">"}</ArrowNav>}
        </>
    );
}

export default InternalNav;