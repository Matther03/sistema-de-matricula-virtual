import { doRequest } from '../helpers';

//#region Secondary
const saveToken = (token) => {
    sessionStorage.setItem("tokenAdmin", token);
}
//#endregion
//#region Main
export const loginAdmin = async (admin) => {
    const [payload, err] = await doRequest(
        "/admin/login", 
        "POST", 
        admin);
    if (!err && payload.data)
        saveToken(payload.data.token);
}
export const isLoggedAdmin = () => 
    sessionStorage.getItem("tokenAdmin") ? true : false;
export const getTokenAdmin = () => 
    sessionStorage.getItem("tokenAdmin");
export const logoutAdmin = () => {
    sessionStorage.clear();
}
//#endregion
