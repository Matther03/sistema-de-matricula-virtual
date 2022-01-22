import { ContainerNav, LinkNav, ArrowNav } from './styles';

const InternalNav = () => {
    return (
        <ContainerNav>
            <ul>
                <li><LinkNav to="/">INICIO</LinkNav></li>
                <ArrowNav>{">"}</ArrowNav>
                <li><LinkNav to="/">MATRÍCULA</LinkNav></li>
                <ArrowNav>{">"}</ArrowNav>
                <li><LinkNav to="/">INFORMACIÓN</LinkNav></li>
            </ul>
        </ContainerNav>
    );
}

export default InternalNav;