//#region Components
import FormInfoStudent from './formInfoStudent/FormInfoStudent';
import FormInfoRepresentative from './formInfoRepresentative/FormInfoRepresentative';
//#endregion

const NewStudent = () => {
    return (
        <>
            <FormInfoStudent/>
            <br></br>
            <FormInfoRepresentative/>
        </>
    );
}

export default NewStudent;