// Styles
import { 
    ContainerSectionHome, 
    HeaderSectionHome, 
    ContentSectionHome 
} from './StylesHome';
// Libraries
import { 
    useState, 
    useEffect, 
} from 'react';
import {
    Button
} from '@mui/material';
// Icons
import { Icon } from '@iconify/react';
// Images
import symbolSchoolImg from '../../../img/school_symbol.png';
// Components
import DialogAlert from '../../../components/general/dialogAlert/DialogAlert';
import CardLinkServiceCampus from '../../../components/home/cardLinkServiceCampus/CardLinkServiceCampus';
// Utils
import changeTitle from '../../../utils/changeTitle';

const Home = () => {
    
    const [open, setOpen] = useState(false);
    const handleOpen = (toOpen = true) => setOpen(toOpen);

    const addClassMainHome = () => {
        const mainElement = document.querySelector('main');
        mainElement.classList.add('home');
        return () => {
            mainElement.classList.remove('home');
        }
    }

    useEffect(() => {
        const removeClassMainHome = addClassMainHome();
        return () => {
            removeClassMainHome();
        };
    });

    return (
        <ContainerSectionHome>
            <HeaderSectionHome>
                <h3 className="custom-title-4">
                    I.E.P VICTOR MANUEL MAURTUA - ICA - PERÚ
                </h3>
                <img src={symbolSchoolImg} alt="Insignia Maurtua Parcona - Ica"/>
            </HeaderSectionHome>
            <ContentSectionHome>
                <CardLinkServiceCampus to="../aula-virtual"
                    title="AULA VIRTUAL"
                    description="Acceso a las clases virtuales y recursos necesarios para el estudiante"
                    icon={<Icon icon="mdi:google-classroom"/>}/>
                <CardLinkServiceCampus to="../intranet"
                    title="INTRANET"
                    description="Acceso a información de los estudiantes como historial de calificaciones, inasistencias, justificaciones."
                    icon={<Icon icon="ant-design:laptop-outlined"/>}/>
                <CardLinkServiceCampus to="../matricula"
                    title="MATRÍCULA"
                    description="Matrícula en línea para estudiantes de la I.E “Victor Manuel Maurtua”."
                    icon={<Icon icon="vaadin:user-card" />}/>
            </ContentSectionHome>
        </ContainerSectionHome>
    );
}

export default Home;