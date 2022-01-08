// Libraries
import { 
    Routes, 
    Route 
} from "react-router-dom";
// Components
import Login from "../views/campus/login/Login.js";
import Home from "../views/campus/home/Home.js";

const Campus = () => {
    return (
        <Routes>
            <Route path="home" element={<Home/>}/>
            <Route path="login" element={<Login/>}/>
            <Route path="*" element={<Login/>}/>
        </Routes>
    );
}

export default Campus;