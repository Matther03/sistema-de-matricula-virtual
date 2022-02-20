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
import RepresentativeDetail from "./components/representativeDetail/RepresentativeDetail";
//#endregion
//#region Utils
import { 
    getDate, 
    getTimeMillis } from "../../../../../utils/date";
import useDidMount from "../../../../../utils/hooks/useDidMount";
//#endregion
//#region Services
import { 
    getStudents,
    getRepresentative 
} from "../../../../../services/admin/studentsRegister";
//#endregion

const keysRows = [
    "dni",
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
    disabledValuesInputsText = {
        values: [], 
        handle: null
    },
    handleChangeInput,
    idxPage 
) => {
    if (tableData.length !== disabledValuesInputsText.values.length) 
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
            numberIdx: (amountRows * idxPage) + idx + 1, 
            ...getRowInputsText(data, idx),
            dateBirth: (
                <InputTable 
                    type="date" 
                    min="2005-01-01"
                    max="2010-12-31"
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
    const [disabledValuesInputsText, setDisabledValuesInputsText] = useState([]);
    const [idxPage, setIdxPage] = useState(0);
    const [quantityPages, setQuantityPages] = useState("?");
    const [representative, setRepresentative] = useState({
        fullName: "", 
        email: "", 
        idCard: "", 
        phone: ""
    });
    const [showRepresentativeDetail, setShowRepresentativeDetail] = useState(false);
    const [loadingRequestGetStudents, setLoadingRequestGetStudents] = useState(false);
    //#endregion
    //#region Effects
    useEffect(() => {
        initTable();
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
        setDisabledValuesInputsText(students.map((_) => ({
            "dni": true,
            "name": true,
            "fatherSurname": true, 
            "motherSurname": true, 
            "address": true, 
            "dateBirth": true
        })));
        setTableData(students.map(student => {
            return {
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
        setShowRepresentativeDetail(true);
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
        const copy = [...disabledValuesInputsText];
        copy[idx] = {
            ...copy[idx],
            [key]: value
        };
        setDisabledValuesInputsText(copy);
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
                                    values: disabledValuesInputsText, 
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
                open={showRepresentativeDetail}
                handleOpen={(value) => setShowRepresentativeDetail(value)}
                title="DETALLE DEL APODERADO"
                description={
                    <RepresentativeDetail data={representative}/>
                }/>
        </>
    );
}

export default StudentRoot;