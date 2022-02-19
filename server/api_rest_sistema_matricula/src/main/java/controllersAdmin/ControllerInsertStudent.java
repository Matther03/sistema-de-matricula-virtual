package controllersAdmin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entity.AdminEntity;
import java.io.IOException;
import java.sql.Date;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;

@WebServlet(name = "ControllerInsertStudent", urlPatterns = {"/api/student/insert-student"})
public class ControllerInsertStudent extends HttpServlet {
    
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
                _dateOfBirth = body.get("dateOfBirth"),
                _dni = body.get("dni"),
                _adress = body.get("adress"),
                _dniRepresentative = body.get("dniRepresentative");
        
        if (areParametersIsNull( _name, _fatherSurname, _motherSurname, _motherSurname, _dni, _adress, _dniRepresentative)) 
            return FormatResponse.getErrorResponse("Mising parameters.", 400);
        
        final AdminEntity adminEntity = new AdminEntity();
        
        final String name = isValidString(_name);
        if (name == null) 
            return  FormatResponse.getErrorResponse("No valid name.", 400);
        final String fatherSurname = isValidString(_fatherSurname);
        if (fatherSurname == null) 
            return  FormatResponse.getErrorResponse("No valid fatherSurname.", 400);
        final String motherSurname = isValidString(_motherSurname);
        if (motherSurname == null) 
            return  FormatResponse.getErrorResponse("No valid motherSurname.", 400);
        Date validDate =isValidDate(_dateOfBirth);
        if (validDate == null) 
            return  FormatResponse.getErrorResponse("No valid dateOfBirth.", 400);
        final String dni = isValidDni(_dni);
        if (dni == null) 
            return  FormatResponse.getErrorResponse("No valid dni.", 400);
        final String adress = _adress.getAsString();
        if (adress == null) 
            return  FormatResponse.getErrorResponse("No valid adress.", 400);
        final String dniRepresentative = isValidDni(_dniRepresentative);
        if (dniRepresentative == null) 
            return  FormatResponse.getErrorResponse("No valid dniRepresentative.", 400);
        
        final String responseInsertStudent = adminEntity.insertStudent(
                name, 
                fatherSurname, 
                motherSurname, 
                validDate , 
                dni, 
                adress, 
                dniRepresentative);
                
        return FormatResponse.getSuccessResponse(responseInsertStudent);
    }
    private boolean areParametersIsNull(
            final JsonElement _name,
            final JsonElement _fatherSurname,
            final JsonElement _motherSurname,
            final JsonElement _dateOfBirth,
            final JsonElement _dni,
            final JsonElement _adress,
            final JsonElement _dniRepresentative) {
        return  _name == null || _fatherSurname == null || _motherSurname == null || 
                _dateOfBirth == null || _dni == null || _adress == null ||_dniRepresentative == null ;
    }
    
    public Date isValidDate(final JsonElement dateJson) {
        try {
            Long dateLong = dateJson.getAsLong();
            final Date date = new Date(dateLong);
            return date ;
        } catch (Exception e) {
            return null;
        }
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
}
