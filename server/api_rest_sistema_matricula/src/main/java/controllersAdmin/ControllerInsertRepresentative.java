package controllersAdmin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.student.StudentDTO;
import entity.AdminEntity;
import entity.StudentEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;

@WebServlet(name = "ControllerInsertRepresentative", urlPatterns = {"/api/student/insert-representative"})
public class ControllerInsertRepresentative extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = doEnrollment(body);
        HelperController.templatePrintable(formatResponse, response);
    }   
    private FormatResponse doEnrollment(final JsonObject body) {
        
    if (body == null)
            return FormatResponse.getErrorResponse("The request body doesn't have json format.", 400);
        final JsonElement 
                _name = body.get("name"),
                _fatherSurname = body.get("fatherSurname"),
                _motherSurname = body.get("motherSurname"),
                _dni = body.get("dni"),
                _email = body.get("email"),
                _phone = body.get("phone");
        
        if (areParametersIsNull( _name, _fatherSurname, _motherSurname,_dni, _email, _phone)) 
            return FormatResponse.getErrorResponse("Mising parameters.", 400);
        
        final String name = isValidString(_name);
        if (name == null) 
            return  FormatResponse.getErrorResponse("No valid name.", 400);
        final String fatherSurname = isValidString(_fatherSurname);
        if (fatherSurname == null) 
            return  FormatResponse.getErrorResponse("No valid fatherSurname.", 400);
        final String motherSurname = isValidString(_motherSurname);
        if (motherSurname == null) 
            return  FormatResponse.getErrorResponse("No valid motherSurname.", 400);
        final String dni = isValidDni(_dni);
        if (dni == null) 
            return  FormatResponse.getErrorResponse("No valid dni.", 400);
        final String email = isValidEmail(_email);
        if (email == null) 
            return  FormatResponse.getErrorResponse("No valid email.", 400);
        final String phone = isValidPhone(_phone);
        if (phone == null) 
            return  FormatResponse.getErrorResponse("No valid phone.", 400);
        
        
        final AdminEntity adminEntity = new AdminEntity();
        
        final String responseInsertRepresentative = adminEntity.inserRepresentative(
                name, 
                fatherSurname, 
                motherSurname,
                dni, 
                email, 
                phone);
                
        return FormatResponse.getSuccessResponse(responseInsertRepresentative);
    }
    private boolean areParametersIsNull(
            final JsonElement _name,
            final JsonElement _fatherSurname,
            final JsonElement _motherSurname,
            final JsonElement _dni,
            final JsonElement _email,
            final JsonElement _phone) {
        return  _dni == null || _name == null || _fatherSurname == null || _motherSurname == null || 
                _email == null || _phone == null ;
    }
    
    public String isValidString(final JsonElement jsonStr){
        try {
            String string = jsonStr.getAsString();
            if (string.matches("[A-ZÁÉÍÓÚÑa-záéíóúñ ]*")) 
                return string;
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public String isValidDni(final JsonElement jsonStr){
        try {
            String string = jsonStr.getAsString();
            if (string.matches("^[0-9]{8,8}$")) 
                return string;
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    public String isValidPhone(final JsonElement jsonStr){
        try {
            String string = jsonStr.getAsString();
            if (string.matches("^[0-9]{6,9}$")) 
                return string;
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    public String isValidEmail(final JsonElement jsonStr){
        try {
            String string = jsonStr.getAsString();
            if (string.matches("^[a-z0-9!#$%&'*"
                    + "+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/"
                    + "=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9]"
                    + ")?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?$")) 
                return string;
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
