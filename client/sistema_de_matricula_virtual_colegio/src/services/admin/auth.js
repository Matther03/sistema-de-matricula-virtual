import { doRequest } from '../helpers';

//#region Secundarias
const saveTokenAdmin = (token) => {
    sessionStorage.setItem("tokenAdmin", token);
}
//#endregion
//#region Principales
export const loginAdmin = (admin) => {
    if (admin.user !== "70290308" || admin.password !== "manuelrivera")
        return;
    saveTokenAdmin("kjckzxkcnjjenjwka");
}
export const isLoggedAdmin = () => sessionStorage.getItem("tokenAdmin") ? true : false;
export const getTokenAdmin = () => sessionStorage.getItem("tokenAdmin");
export const logoutAdmin = () => {
    sessionStorage.removeItem("tokenAdmin");
}
//#endregion