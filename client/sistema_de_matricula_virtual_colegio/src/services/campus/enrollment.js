//#region Services
import { doRequestCampus } from './general';
//#endregion

//#region Main
export const getSections = async () => {
    return await doRequestCampus(
        "/student", "GET");
}
//#endregion