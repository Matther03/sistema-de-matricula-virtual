//#region Libraries
import { 
    useState 
} from 'react';
//#endregion
//#region Styles
import { 
    ContainerEnrollmentDataInformation, 
    HeaderEnrollmentDataInformation, 
    ContentEnrollmentDataInformation, 
    ContainerDataDetail  } from './styles';
//#endregion

const dataDetails = [
    [
        { description: "APELLIDOS Y NOMBRES", value: "PEÑA MARTINEZ, JOEL PIERO" },
        { description: "GRADO ACADÉMICO", value: "1ERO  - SECUNDARIA" },
        { description: "SECCIÓN", value: "A" },
        { description: "TURNO", value: "MAÑANA" },
    ], 
    [
        { description: "CÓDIGO DEL ESTUDIANTE", value: "20181234" },
        { description: "DOCUMENTO DE IDENTIDAD", value: "12345678" },
        { description: "CÓDIGO DE MATRÍCULA", value: "12356489" },
        { description: "FECHA DE MATRÍCULA", value: new Date().getDay()  },
    ]
];

const EnrollmentDataInformation = () => {
    //#region States
    //#endregion
    return (
        <ContainerEnrollmentDataInformation>
            <HeaderEnrollmentDataInformation>
                <h2 className="custom-title-2">INFORMACIÓN DE MATRÍCULA</h2>
                <hr/>
            </HeaderEnrollmentDataInformation>
            <ContentEnrollmentDataInformation>
                {dataDetails.map((column, idx1) => (
                    <div key={idx1} className="column">
                        {column.map((dataDetail, idx2) => (
                            <DataDetail
                                key={idx2} 
                                description={dataDetail.description}
                                value={dataDetail.value}/>
                        ))}
                    </div>
                ))}
            </ContentEnrollmentDataInformation>
        </ContainerEnrollmentDataInformation>
    );
}

const DataDetail = ({ description, value }) => {
    return (
        <ContainerDataDetail>
            <span className="description">{description}: </span>
            <span>{value}</span>
        </ContainerDataDetail>
    );
}

export default EnrollmentDataInformation;