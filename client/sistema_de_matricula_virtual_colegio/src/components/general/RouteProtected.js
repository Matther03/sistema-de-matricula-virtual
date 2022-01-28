import { Navigate } from 'react-router-dom';
import { isLoggedAdmin, isLoggedStudent } from '../../services/auth';

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