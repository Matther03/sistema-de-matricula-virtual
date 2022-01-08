//#region Libraries
import { 
    BrowserRouter, 
    Routes, 
    Route 
} from "react-router-dom";
//#endregion
//#region Components
import Campus from './Campus';
import Administrator from './Administrator';
import MainFooter from '../components/general/mainFooter/MainFooter';
//#endregion

const Main = () => {
    return (
        <main>
            <BrowserRouter>
                <Routes>
                    <Route path="campus/*" element={<Campus/>}/>
                    <Route path="administrador/*" element={<Administrator/>}/>
                    <Route path="*" element={<Campus/>}/>
                </Routes>
                <MainFooter/>
            </BrowserRouter>
        </main>
    );
}

export default Main;