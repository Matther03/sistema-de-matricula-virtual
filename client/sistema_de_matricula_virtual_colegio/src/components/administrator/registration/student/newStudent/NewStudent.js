//#region Components
import FormInfoStudent from './formInfoStudent/FormInfoStudent';
import FormInfoRepresentative from './formInfoRepresentative/FormInfoRepresentative';
//#endregion

const NewStudent = () => {
    return (
        <>
            <FormInfoStudent/>
            <FormInfoRepresentative/>
        </>
    );
}

export default NewStudent;