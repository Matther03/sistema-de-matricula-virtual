import { 
    ContainerEnrollmentDataInformation, 
    HeaderEnrollmentDataInformation,
    ContentEnrollmentDataInformation,
    ContainerDataDetail  } from './styles';

const EnrollmentDataInformation = () => {
    return (
        <ContainerEnrollmentDataInformation>
            <HeaderEnrollmentDataInformation>
                <h2>INFORMACIÓN DE MATRÍCULA</h2>
                <hr/>
            </HeaderEnrollmentDataInformation>
            <ContentEnrollmentDataInformation>
                <div class="column">
                    <DataDetail 
                        description="APELLIDOS Y NOMBRES"
                        value=""/>
                    <DataDetail 
                        description="GRADO ACADÉMICO"
                        value=""/>
                    <DataDetail 
                        description="SECCIÓN"
                        value=""/>
                    <DataDetail 
                        description="TURNO"
                        value=""/>
                </div>
                <div class="column">
                    <DataDetail 
                        description="CÓDIGO DEL ESTUDIANTE"
                        value=""/>
                    <DataDetail 
                        description="DOCUMENTO DE IDENTIDAD"
                        value=""/>
                    <DataDetail 
                        description="CÓDIGO DE MATRÍCULA"
                        value=""/>
                    <DataDetail 
                        description="FECHA DE MATRÍCULA"
                        value=""/>
                </div>
            </ContentEnrollmentDataInformation>
        </ContainerEnrollmentDataInformation>
    );
}

const DataDetail = ({ description, value }) => {
    return (
        <ContainerDataDetail>
            <span class="description">{description}: </span>
            <span>{value}</span>
        </ContainerDataDetail>
    );
}

export default EnrollmentDataInformation;