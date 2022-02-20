import { doRequestAdmin } from "./general";

// #region Main
export const getStudents = async (limitTop, seeSize = false) => {
    return await doRequestAdmin(
        `/student/register?limitTop=${limitTop + 1}&&seeSize=${seeSize}`, "GET");
}
export const getRepresentative = async (codeStudent) => {
    return await doRequestAdmin(
        `/student/representative?codeStudent=${codeStudent}`, "GET");
}
export const updateStudent = async (student) => {
    return await doRequestAdmin(
        `/student/register`, "PUT", student);
}
// #endregion