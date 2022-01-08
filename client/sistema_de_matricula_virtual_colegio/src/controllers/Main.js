// Libraries
import { 
    BrowserRouter, 
    Routes, 
    Route 
} from "react-router-dom";
// Utils
import history from '../utils/history.js'
// Components
import Campus from './Campus';
import Administrator from './Administrator';
import MainFooter from '../components/mainFooter/MainFooter.js';

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