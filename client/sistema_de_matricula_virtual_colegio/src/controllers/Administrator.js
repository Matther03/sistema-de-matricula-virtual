// Libraries
import { 
    BrowserRouter, 
    Routes, 
    Route 
} from "react-router-dom";
import Home from "../views/administrator/home/Home";

const Administrator = () => {
    return (
        <Routes>
            <Route path="*" element={<Home/>}/>
        </Routes>
    );
}

export default Administrator;