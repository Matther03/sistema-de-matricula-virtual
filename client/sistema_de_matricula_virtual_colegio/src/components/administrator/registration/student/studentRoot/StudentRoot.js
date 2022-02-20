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
    Content, 
    DetailRow, 
    Container, 
    FooterDataTable, 
    IndexerPages, 
    ButtonChangePage 
} from "./styles";
//#endregion
//#region Components
import CustomDataTable, { 
    InputTable 
} from "../../../../general/customDataTable/CustomDataTable";
import DialogAlert from "../../../../general/dialogAlert/DialogAlert";
import CustomButton from "../../../../general/customButton/CustomButton";
import RepresentativeDetail from "./components/representativeDetail/RepresentativeDetail";
//#endregion
//#region Utils
import { 
    getDate, 
    getTimeMillis } from "../../../../../utils/date";
import useDidMount from "../../../../../utils/hooks/useDidMount";
import { handleKeyPressOnlyNumbers } from "../../../../../utils/validation";
//#endregion
//#region Services
import { 
    getStudents,
    getRepresentative, 
    updateStudent 
} from "../../../../../services/admin/studentsRegister";
//#endregion

const keysRows = [
    "name", 
    "fatherSurname", 
    "motherSurname", 
    "address"
];
const amountRows = 3;

const rowsToDataTable = (
    tableData = [], 
    openRepresentativeDetail, 
    desactiveStudent, 
    disabledValuesInputs = {
        values: [], 
        handle: null
    },
    handleChangeInput 
) => {
    if (tableData.length !== disabledValuesInputs.values.length) 
        return [];
    const getRowInputsText = (data, idx) => keysRows.reduce((acc, key) => {
        const newObj = {
            ...acc, 
            [key]: (
                <InputTable 
                    value={data[key]} 
                    onKeyPress={(e) => handleEnterDisableValuesInput(e, idx, key)}
                    onChange={(e) => handleChangeInput(idx, key, e.target.value)}
                    onDoubleClick={(e) => {
                        disabledValuesInputs.handle(idx, key, false);
                        setFocusUpdateInput(e);
                    }}
                    onBlur={() => {
                        disabledValuesInputs.handle(idx, key, true);
                    }}
                    disabled={disabledValuesInputs.values[idx][key]}/>
                )
        };
        return newObj;
    }, {});
    const setFocusUpdateInput = (e) => {
        setTimeout(() => {
            e.target.parentElement.children[0].focus();
        }, 100);
    }
    const handleEnterDisableValuesInput = (e, idx, key) => {
        if (e.key === "Enter") {
            disabledValuesInputs.handle(idx, key, true);
            return;
        }
    }
    return tableData.map((data, idx) => ({
            numberIdx: data.numberIdx, 
            dni: (
                <InputTable 
                    value={data.dni} 
                    maxLength="8"
                    onKeyPress={(e) => {
                        handleEnterDisableValuesInput(e, idx, "dni");
                        handleKeyPressOnlyNumbers(e);
                    }} 
                    onChange={(e) => handleChangeInput(idx, "dni", e.target.value)}
                    onDoubleClick={(e) => {
                        disabledValuesInputs.handle(idx, "dni", false);
                        setFocusUpdateInput(e);
                    }}
                    onBlur={() => {
                        disabledValuesInputs.handle(idx, "dni", true);
                    }}
                    disabled={disabledValuesInputs.values[idx].dni}/>
            ),
            ...getRowInputsText(data, idx), 
            dateBirth: (
                <InputTable 
                    type="date" 
                    min="2005-01-01"
                    max="2010-12-31"
                    onKeyPress={(e) => handleEnterDisableValuesInput(e, idx, "dateBirth")}
                    onChange={
                        (e) => handleChangeInput(
                            idx, 
                            "dateBirth", 
                            {
                                date: e.target.value,
                                value: getTimeMillis(e.target.value)
                            })} 
                    value={data.dateBirth.date}
                    onDoubleClick={(e) => {
                        disabledValuesInputs.handle(idx, "dateBirth", false);
                        setFocusUpdateInput(e);
                    }}
                    onBlur={() => {
                        disabledValuesInputs.handle(idx, "dateBirth", true);
                    }}
                    disabled={disabledValuesInputs.values[idx].dateBirth}/>
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
    );
}
const fieldsDataTable = [
    "N°",
    "DNI",
    "NOMBRES",
    "APELLIDO PATERNO",
    "APELLIDO MATERNO",
    "DIRECCIÓN",
    "FECHA DE NACIMIENTO",
    "APODERADO",
    "ACTIVO" 
];
const StudentRoot = () => {
    //#region Extra hooks
    const didMount = useDidMount();
    //#endregion
    //#region States
    const [tableData, setTableData] = useState([]);
    const [disabledValuesInputs, setDisabledValuesInputs] = useState([]);
    const [idxPage, setIdxPage] = useState(0);
    const [quantityPages, setQuantityPages] = useState("?");
    const [representative, setRepresentative] = useState({
        fullName: "", 
        email: "", 
        idCard: "", 
        phone: ""
    });
    const [showDialogs, setShowDialogs] = useState({
        representativeDetail: false,
        confirmUpdate: false  
    });
    const [loadingRequestGetStudents, setLoadingRequestGetStudents] = useState(false);
    const [valueBeforeUpdateField, setValueBeforeUpdateField] = useState(null);
    //#endregion
    //#region Effects
    useEffect(() => {
        initTable();
        // (async () => {
        //     const res = await updateStudent({});
        //     console.log(res);
        // })();
    }, []);
    useEffect(() => {
        didMount && handlerChangePageEffect();
    }, [idxPage]);
    //#endregion 
    //#region Functions
    const doGetStudents = async (seeSize) => {
        setLoadingRequestGetStudents(true);
        const [payload, err] = await getStudents(idxPage*amountRows, seeSize);
        setLoadingRequestGetStudents(false);
        if (err || !payload.data)
        {
            console.log(err);
            return null;
        }
        return payload.data;
    }
    const initTable = async () => {
        const data = await doGetStudents(true);
        if (!data)
            return;
        const { students, totalSize } = data;
        changeQuantityPages(totalSize);
        fillDataStudents(students);
    }
    const handlerChangePageEffect = async () => {
        const data = await doGetStudents();
        if (!data) 
            return;
        const { students } = data;
        fillDataStudents(students);
    }
    const fillDataStudents = (students = []) => {
        setDisabledValuesInputs(students.map((_) => ({
            "dni": true,
            "name": true,
            "fatherSurname": true, 
            "motherSurname": true, 
            "address": true, 
            "dateBirth": true 
        })));
        console.log(students);
        setTableData(students.map((student, idx) => {
            return {
                numberIdx: (amountRows * idxPage) + idx + 1, 
                ...student, 
                dateBirth: {
                    date: getDate(student.dateBirth, true), 
                    value: student.dateBirth
                }
            };
        }));
    }
    const changeQuantityPages = (totalSize) => {
        setQuantityPages(Math.ceil(totalSize / amountRows));
    }
    const handleChangeInput = (idx, key, value) => {
        const copy = [...tableData];
        copy[idx] = {
            ...copy[idx],
            [key]: value
        };
        setTableData(copy);
    }
    const openRepresentativeDetail = async (code) => {
        const [payload, err] = await getRepresentative(code);
        handleShowDialog("representativeDetail", true);
        if (err || !payload.data) 
            return;
        const { 
            name, 
            fatherSurname, 
            motherSurname, 
            ...restData } = payload.data[0];
        let obj = {
            ...restData, 
            fullName: `${fatherSurname} ${motherSurname}, ${name}`
        };
        setRepresentative(obj);
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
    const handleDisabledValuesTextFields = (idx, key, value) => {
        const copy = [...disabledValuesInputs];
        copy[idx] = {
            ...copy[idx],
            [key]: value
        };
        setDisabledValuesInputs(copy);
        handleValueBeforeUpdateField(idx, key, value);
    }
    const handleValueBeforeUpdateField = (idx, key, value) => {
        const dataField = tableData[idx][key];
        if (!value) {
            setValueBeforeUpdateField(prev => prev === null ? {
                idx,
                key, 
                value: dataField 
            } : prev);
            return;
        }
        if (dataField === valueBeforeUpdateField.value) {
            setValueBeforeUpdateField(null);
            return;
        }
        handleShowDialog("confirmUpdate", true);
    }
    const handleShowDialog = (key, value) => {
        setShowDialogs(prev => ({
            ...prev, 
            [key]: value
        }));
    }
    const cancelUpdateField = () => {
        const copy = [...tableData];
        const { idx, key, value } = valueBeforeUpdateField;
        copy[idx] = {
            ...copy[idx],
            [key]: value
        };
        setTableData(copy);
        setValueBeforeUpdateField(null);
        handleShowDialog("confirmUpdate", false);
    }
    //#endregion
    return (
        <>
            <Container>
                <Title className="custom-title-2">
                    REGISTROS DE ALUMNOS
                </Title>
                <Content>
                    <CustomDataTable 
                        className="secondary"
                        fields={fieldsDataTable}
                        rows={rowsToDataTable(
                                tableData, 
                                openRepresentativeDetail,
                                desactiveStudent, 
                                {
                                    values: disabledValuesInputs, 
                                    handle: handleDisabledValuesTextFields
                                },
                                handleChangeInput, 
                                idxPage)}/>
                    <FooterDataTable>
                        {idxPage === 0 
                            ? <span className="offset"></span>
                            : <ButtonChangePage 
                                onClick={() => {
                                    setIdxPage(prev => prev - 1);
                                }}
                                text="Atrás"
                                disabled={loadingRequestGetStudents}
                                loading={loadingRequestGetStudents}/>
                        }
                        <IndexerPages>Página {idxPage + 1} / {quantityPages}</IndexerPages>
                        {idxPage === quantityPages - 1 
                            ? <span className="offset"></span>
                            : <ButtonChangePage 
                                onClick={() => {
                                    setIdxPage(prev => prev + 1);
                                }}
                                text="Siguiente"
                                disabled={loadingRequestGetStudents}
                                loading={loadingRequestGetStudents}/>
                        }
                    </FooterDataTable>
                </Content>
            </Container>
            <DialogAlert 
                open={showDialogs.representativeDetail}
                handleOpen={(value) => handleShowDialog("representativeDetail", value)}
                title="DETALLE DEL APODERADO"
                description={
                    <RepresentativeDetail data={representative}/>
                }/>
            <DialogAlert 
                open={showDialogs.confirmUpdate}
                handleOpen={(value) => handleShowDialog("confirmUpdate", value)}
                handleClose={cancelUpdateField}
                title="AVISO"
                description={
                    <p>¿Desea actualizar este campo?</p>
                }
                buttons={[
                    () => <CustomButton 
                            text="Aceptar"
                            variant="outlined"
                            onClick={() => {
                                setValueBeforeUpdateField(null);
                                handleShowDialog("confirmUpdate", false);
                            }}/>,
                    () => <CustomButton 
                            text="Cancelar"
                            variant="outlined"
                            onClick={cancelUpdateField}/>
                ]}/>
        </>
    );
}

export default StudentRoot;