import { doRequestAdmin } from "./general";

// #region Main
export const getStudents = async (limitTop) => 
    await doRequestAdmin(
        `/student/register?limitTop=${limitTop}`, "GET");
// #endregion