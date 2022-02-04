import { Navigate } from 'react-router-dom';
import { isLoggedStudent } from '../../services/campus/auth';
import { isLoggedAdmin } from '../../services/admin/auth';

const RouteProtected = ({ element, isLogged, to }) => {
    return isLogged()
        ? element
        : <Navigate to={to} replace={true}/>;
}
export const RouteProtectedStudent = ({ children, to }) => {
    return (
        <RouteProtected 
            to="../login" element={children} 
            isLogged={isLoggedStudent}/>
    );
}
export const RouteProtectedAdmin = ({ children }) => {
    return (
        <RouteProtected 
            to="../login" element={children} 
            isLogged={isLoggedAdmin}/>
    );
}