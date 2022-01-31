// Student
export const loginStudent = (student) => {
    if (student.dni !== "70290308" || student.password !== "manuelrivera")
        return;
    saveToken("kjckzxkcnjjenjwka");
}
export const isLoggedStudent = () => sessionStorage.getItem("tokenStudent") ? true : false;
const saveToken = (token) => {
    sessionStorage.setItem("tokenStudent", token);
}
export const logoutStudent = () => {
    sessionStorage.removeItem("tokenStudent");
}

// Admin
export const loginAdmin = (admin) => {
    if (admin.user !== "70290308" || admin.password !== "manuelrivera")
        return;
    saveTokenAdmin("kjckzxkcnjjenjwka");
}
export const isLoggedAdmin = () => sessionStorage.getItem("tokenAdmin") ? true : false;
const saveTokenAdmin = (token) => {
    sessionStorage.setItem("tokenAdmin", token);
}
export const logoutAdmin = () => {
    sessionStorage.removeItem("tokenAdmin");
}