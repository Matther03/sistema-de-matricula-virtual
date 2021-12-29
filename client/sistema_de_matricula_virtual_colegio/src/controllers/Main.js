import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from "../views/Login";
import Navbar from "../components/Navbar";

const Main = () => {
    return (
        <BrowserRouter>
            <Navbar/>
            <Routes>
                <Route path="/login" element={<Login/>}/>
                <Route path="/" element={<div>Hola</div>}/>
            </Routes>
        </BrowserRouter>
    );
}

export default Main;