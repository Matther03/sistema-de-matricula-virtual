import { doRequest } from '../helpers';

//#region Secondary
const saveToken = (token) => {
    sessionStorage.setItem("tokenStudent", token);
}
//#endregion
//#region Main
export const loginStudent = async (student) => {
    const [payload, err] = await doRequest(
        "/student/login", 
        "POST", 
        student);
    if (!err && payload.data)
        saveToken(payload.data.token);
}
export const isLoggedStudent = () => 
    sessionStorage.getItem("tokenStudent") ? true : false;
export const getTokenStudent = () => 
    sessionStorage.getItem("tokenStudent");
export const logoutStudent = () => {
    sessionStorage.clear();
}
//#endregion
