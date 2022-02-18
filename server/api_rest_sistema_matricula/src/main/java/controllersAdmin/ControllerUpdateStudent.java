package controllersAdmin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.enrollment.EnrollmentDTO;
import entity.AdminEntity;
import entity.StudentEntity;
import entity.ValidateInput;
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
        
        final ValidateInput validateImput = new ValidateInput();
        final String dni = validateImput.isValidDNI(_dni.toString());
        if (dni == null) 
            return FormatResponse.getErrorResponse("Error en dni.", 400);
        final String name = _name.toString();
        final String fatherSurname = _fatherSurname.toString();
        final String motherSurname = _motherSurname.toString();
        final String direction = _direction.toString();
        final Date date = validateImput.isValidDate(_dateOfBirth.getAsString());
        if (date == null) 
            return FormatResponse.getErrorResponse("Error en fecha.", 400);
        final String active = _active.toString();
        final Integer codeStudent = validateImput.isValidCodeStudent(_codeStudent.toString());

            
        //final Date dateOfBirth = Date.valueOf(date_);
        /*final Integer codeStuden = studentEntity.isValidCodeStudent(_codeStudent.toString());
        
        if (codeStuden == null) return FormatResponse.getErrorResponse("The code student is not valid.", 400);
        
        final Boolean responseUpdateStudent = adminStudent.updateStudent(
                dni, name, fatherSurname, motherSurname, direction, date_, active, codeStuden);
        if (responseUpdateStudent==null) {
            return FormatResponse.getErrorResponse("The student error.", 400);
        }
        

        data.addProperty("Response", responseUpdateStudent);*/
        final JsonObject data = new JsonObject();
            data.addProperty("dni", dni);
            data.addProperty("nombre", name);
            data.addProperty("apellidoPaterno", fatherSurname);
            data.addProperty("apellidoMaterno", motherSurname);
            data.addProperty("direccion", direction);
            data.addProperty("date", date.toString());
            data.addProperty("active", active);
            data.addProperty("codeStudent", codeStudent);
        return FormatResponse.getSuccessResponse(data);
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
