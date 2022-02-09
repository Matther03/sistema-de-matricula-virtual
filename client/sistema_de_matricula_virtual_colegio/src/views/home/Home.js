// Styles
import { 
    ContainerSectionHome, 
    HeaderSectionHome, 
    ContentSectionHome, 
    HeaderProfileHome
} from './styles';
//#region Libraries
import { 
    // useState, 
    useEffect 
} from 'react';
// import {
//     Button
// } from '@mui/material';
//#endregion
//#region Icons
import { Icon } from '@iconify/react';
//#endregion
//#region Images
import symbolSchoolImg from '../../../img/general/school-symbol.png';
//#endregion
//#region Components
// import DialogAlert from '../../../components/general/dialogAlert/DialogAlert';

import CardLinkServiceCampus from '../../../components/campus/home/components/cardLinkServiceCampus/CardLinkServiceCampus';
//#endregion

const Home = () => {
    //#region States
    //#endregion
    //#region Functions
    //#endregion
    //#region Effects
    //#endregion

    return (
        <ContainerSectionHome>
            <SymbolHeader/>
            <ContentSectionHome>
                <CardLinkServiceCampus to="../aula-virtual"
                    title="AULA VIRTUAL"
                    description="Acceso a las clases virtuales y recursos necesarios para el estudiante"
                    icon={<Icon icon="mdi:google-classroom"/>}/>
                <CardLinkServiceCampus to="../intranet"
                    title="INTRAANET"
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