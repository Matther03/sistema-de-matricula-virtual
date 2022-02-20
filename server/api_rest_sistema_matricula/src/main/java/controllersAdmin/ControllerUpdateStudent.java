package controllersAdmin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import entity.AdminEntity;
import entity.StudentEntity;
import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.AdminModel;
import utils.FormatResponse;
import utils.HelperController;

@WebServlet(name = "ControllerUpdateStudent", urlPatterns = {"/api/student/update"})
public class ControllerUpdateStudent extends HttpServlet {
    
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 

        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = updateStudent(body);
        HelperController.templatePrintable(formatResponse, response);
    }
  
    private FormatResponse updateStudent(final JsonObject body) {
        //Validacion del body
        if (body == null)
            return FormatResponse.getErrorResponse("The request body doesn't have json format.", 400);
        final JsonElement 
                _dni = body.get("dni"),
                _name = body.get("name"),
                _fatherSurname = body.get("fatherSurname"),
                _motherSurname = body.get("motherSurname"),
                _direction = body.get("direction"),
                _dateOfBirth = body.get("dateOfBirth"),
                _active = body.get("active"),
                _codeStudent = body.get("codeStudent");
        
        if (areParametersIsNull(_dni, _name, _fatherSurname, _motherSurname, _direction, 
                _dateOfBirth,_active,_codeStudent)) 
            return FormatResponse.getErrorResponse("Mising parameters.", 400);
        
        final StudentEntity studentEntity = new StudentEntity();
        
        //validacion de datos ingresados
        final String dni = studentEntity.isValidDNI(_dni.toString());
        if (dni == null) 
            return FormatResponse.getErrorResponse("Error en dni.", 400);
        final String name = _name.getAsString();
        final String fatherSurname = _fatherSurname.getAsString();
        final String motherSurname = _motherSurname.getAsString();
        final String direction = _direction.getAsString();
        final Date date = studentEntity.isValidDate(_dateOfBirth.getAsString());
        if (date == null) 
            return FormatResponse.getErrorResponse("Error en fecha.", 400);
        final Boolean active = studentEntity.isValidBoolean(_active.toString());
        if (active == null) 
            return FormatResponse.getErrorResponse("Error en active.", 400);
        final Integer codeStudent = studentEntity.isValidCodeStudent(_codeStudent.toString());
        if (codeStudent == null) 
            return FormatResponse.getErrorResponse("Error en codeStudent.", 400);
        final AdminEntity adminEntity = new AdminEntity();
        
        
        final String responseUpdateStudent = adminEntity.updateStudent(
                dni, name, fatherSurname, motherSurname, direction, date,
                active, codeStudent);
        if (responseUpdateStudent == null) {
            return FormatResponse.getErrorResponse("The student error in responseUpdateStudent.", 400);
        }
        
        final  ArrayList<HashMap<String, String>> actualizar = new AdminModel().updateStudent(
                dni, name, fatherSurname, motherSurname, direction, date,
                active, codeStudent);
        
        /*final Boolean responseUpdate = adminEntity.studentUpdate(dni, name, fatherSurname, 
                motherSurname, direction, date, active, codeStudent);
        if (responseUpdate == false) {
            return FormatResponse.getErrorResponse("The student does not meet any requirement.", 400);
        }
        final JsonObject data = new JsonObject();
            data.addProperty("dni", dni.getClass().getSimpleName());
            data.addProperty("nombre", name.getClass().getSimpleName());
            data.addProperty("apellidoPaterno", fatherSurname.getClass().getSimpleName());
            data.addProperty("apellidoMaterno", motherSurname.getClass().getSimpleName());
            data.addProperty("direccion", direction.getClass().getSimpleName());
            data.addProperty("date", date.getClass().getSimpleName());
            data.addProperty("active", active.getClass().getSimpleName());
            data.addProperty("codeStudent", codeStudent.getClass().getSimpleName());
        */
        return FormatResponse.getSuccessResponse(actualizar);
    }
    
    private boolean areParametersIsNull(
            final JsonElement _dni,
            final JsonElement _name,
            final JsonElement _fatherSurname,
            final JsonElement _motherSurname,
            final JsonElement _direction,
            final JsonElement _dateOfBirth,
            final JsonElement _active,
            final JsonElement _codeStudent) {
        return  _dni == null || _name == null || _fatherSurname == null || _motherSurname == null || 
                _direction == null || _dateOfBirth == null || _active == null || _codeStudent == null;
    }
}
