//#region Services
import { doRequestCampus } from './general';
//#endregion

//#region Principales
export const getSections = async () => {
    return await doRequestCampus(
        "/student", "GET", 
        null);
}
//#endregion