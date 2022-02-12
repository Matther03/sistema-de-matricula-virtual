//#region Libraries
import {
    useState,
    useEffect 
} from "react";
import {
    Switch
} from "@mui/material";
//#endregion
//#region Styles
import {
    Title, 
    DetailRow, 
    Container 
} from "./styles";
//#endregion
//#region Components
import CustomDataTable, { InputTable } from "../../../../general/customDataTable/CustomDataTable";
//#endregion

const rowsToDataTable = (
    tableData = [], 
    openRepresentativeDetail, 
    desactiveStudent, 
    disabledValuesInputsText = {
        values: [], 
        handle: null
    },
    handleChangeInputText 
) => {
    const getRowInputsText = (data, idx) => [
        "dni",
        "names", 
        "fatherSurname", 
        "motherSurname", 
        "address"
    ].reduce((acc, key) => {
        const newObj = {
            ...acc,
            [key]: (
                <InputTable 
                    value={data[key]} 
                    onChange={(e) => handleChangeInputText(idx, key, e.target.value)}
                    onDoubleClick={(e) => {
                        disabledValuesInputsText.handle(idx, key, false);
                        setTimeout(() => {
                            e.target.parentElement.children[0].focus();
                        }, 100);
                    }}
                    onBlur={() => {
                        disabledValuesInputsText.handle(idx, key, true);
                    }}
                    disabled={disabledValuesInputsText.values[idx][key]}/>
                )
        };
        return newObj;
    }, {});
    
    return tableData.map((data, idx) => ({
            ...getRowInputsText(data, idx),
            dateOfBirth: (
                <InputTable onChange={(e) => handleChangeInputText(idx, "dateOfBirth", e.target.value)} value={data.dateOfBirth}/>
            ), 
            representative: (
                <DetailRow 
                    onClick={() => openRepresentativeDetail(data.code)}>
                        Detalle
                </DetailRow>
            ), 
            active: (
                <Switch 
                    checked={data.active}
                    onChange={() => desactiveStudent(idx)}/>
            )
        })
    )
}
const fieldsDataTable = [
    "N° DNI",
    "NOMBRES",
    "APELLIDO PATERNO",
    "APELLIDO MATERNO",
    "DIRECCIÓN",
    "FECHA DE NACIMIENTO",
    "APODERADO",
    "ACTIVO" 
];
const generateTestData = () => {
    const newData = [];
    for (let i = 1; i <= 10; i++) {
        newData.push({
            code: i, 
            dni: "70290308", 
            names: "Manuel Alejandro", 
            fatherSurname: "Rivera", 
            motherSurname: "Becerra", 
            address: "Av. Las Palmeras", 
            dateOfBirth: "12/12/2012", 
            active: false
        })
    }
    return newData;
}

const StudentRoot = () => {
    //#region States
    const [tableData, setTableData] = useState([]);
    const [disabledValuesInputsText, setDisabledValuesInputsText] = useState([]);
    //#endregion 
    //#region Effects
    useEffect(() => {
        const generated = generateTestData();
        setTableData(generated);
        setDisabledValuesInputsText(generated.map((_) => ({
            "dni": true,
            "names": true,
            "fatherSurname": true,
            "motherSurname": true,
            "address": true
        })));
    }, []);
    //#endregion 
    //#region Functions
    const handleChangeInputText = (idx, key, value) => {
        const copy = [...tableData];
        copy[idx] = {
            ...copy[idx],
            [key]: value
        };
        setTableData(copy);
    }
    const openRepresentativeDetail = (code) => {
        console.log(code);
    }
    const desactiveStudent = (idx) => {
        const copy = [...tableData];
        const row = copy[idx];
        copy[idx] = {
            ...row,
            active: !row.active
        };
        setTableData(copy);
    }
    //#endregion
    const handleDisabledValuesTextFields = (idx, key, value) => {
        const copy = [...disabledValuesInputsText];
        copy[idx] = {
            ...copy[idx],
            [key]: value
        };
        setDisabledValuesInputsText(copy);
    }
    return (
        <Container>
            <Title className="custom-title-2">
                REGISTROS DE ALUMNO
            </Title>
            <CustomDataTable 
                className="secondary"
                fields={fieldsDataTable}
                rows={rowsToDataTable(
                        tableData, 
                        openRepresentativeDetail,
                        desactiveStudent, 
                        {
                            values: disabledValuesInputsText, 
                            handle: handleDisabledValuesTextFields
                        },
                        handleChangeInputText)}/>
        </Container>
    );
}

export default StudentRoot;