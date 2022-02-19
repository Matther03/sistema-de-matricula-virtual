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
import CustomDataTable, { 
    InputTable 
} from "../../../../general/customDataTable/CustomDataTable";
//#endregion
//#region Components
import CustomButton from "../../../../general/customButton/CustomButton";
//#endregion
//#region Utils
import { getDate } from "../../../../../utils/date";
//#endregion
//#region Services
import { getStudents } from "../../../../../services/admin/studentsRegister";
//#endregion

const keysRows = [
    "dni",
    "name", 
    "fatherSurname", 
    "motherSurname", 
    "address"
];

const rowsToDataTable = (
    tableData = [], 
    openRepresentativeDetail, 
    desactiveStudent, 
    disabledValuesInputsText = {
        values: [], 
        handle: null
    },
    handleChangeInput 
) => {
    if (tableData.length < 1 || disabledValuesInputsText.values.length < 1) 
        return [];
    const getRowInputsText = (data, idx) => keysRows.reduce((acc, key) => {
        const newObj = {
            ...acc,
            [key]: (
                <InputTable 
                    value={data[key]} 
                    onChange={(e) => handleChangeInput(idx, key, e.target.value)}
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
            dateBirth: (
                <InputTable 
                    onChange={
                        (e) => handleChangeInput(
                            idx, 
                            "dateBirth", 
                            {
                                date: getDate(e.target.value),
                                value: e.target.value
                            })} 
                    value={data.dateBirth.date}
                    onDoubleClick={(e) => {
                        disabledValuesInputsText.handle(idx, "dateBirth", false);
                        setTimeout(() => {
                            e.target.parentElement.children[0].focus();
                        }, 100);
                    }}
                    onBlur={() => {
                        disabledValuesInputsText.handle(idx, "dateBirth", true);
                    }}
                    disabled={disabledValuesInputsText.values[idx].dateBirth}/>
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
            name: "Manuel Alejandro", 
            fatherSurname: "Rivera", 
            motherSurname: "Becerra", 
            address: "Av. Las Palmeras", 
            dateBirth: {
                date: "17/12/2000",
                value: 0
            }, 
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
        doGetStudents();
    }, []);
    //#endregion 
    //#region Functions
    const doGetStudents = async () => {
        const [payload, err] = await getStudents(1);
        if (!payload.data || err)
        {
            console.log(err);
            return;
        }
        console.log(payload.data);
        const { studentRegister } = payload.data;
        setDisabledValuesInputsText(studentRegister.map((_) => ({
            "dni": true,
            "name": true,
            "fatherSurname": true, 
            "motherSurname": true, 
            "address": true, 
            "dateBirth": true
        })));
        setTableData(studentRegister);
    }
    const handleChangeInput = (idx, key, value) => {
        console.log(value);
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
                        handleChangeInput)}/>
        </Container>
    );
}

export default StudentRoot;