package controllersAdmin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.enrollment.EnrollmentDTO;
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

@WebServlet(name = "ControllerUpdateStudent", urlPatterns = {"/api/student/update"})
public class ControllerUpdateStudent extends HttpServlet {
  /*   protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException { 

        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = getDetailEnrollent(body);
        HelperController.templatePrintable(formatResponse, response);
    }
  
    private FormatResponse getDetailEnrollent(final JsonObject body) {
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
        
        if (_dni == null || _name == null || _fatherSurname == null || _motherSurname == null || 
                _direction == null || _dateOfBirth == null || _active == null || _codeStudent == null) 
            return FormatResponse.getErrorResponse("Mising parameters.", 400);
        
        // Validación del codigo de estudiante
        final StudentEntity studentEntity = new StudentEntity();
        final AdminEntity adminStudent = new AdminEntity();
        
        final String dni = _dni.toString();
        final String name = _name.toString();
        final String fatherSurname = _fatherSurname.toString();
        final String motherSurname = _motherSurname.toString();
        final String direction = _direction.toString();
        final String date_ = _dateOfBirth.toString();  
        final String activ = _active.toString();
        Boolean active = false ;
        if ("1".equals(activ)) {
            active = true;
        }
        //final Date dateOfBirth = Date.valueOf(date_);
        final Integer codeStuden = studentEntity.isValidCodeStudent(_codeStudent.toString());
        
        if (codeStuden == null) return FormatResponse.getErrorResponse("The code student is not valid.", 400);
        
        final Boolean responseUpdateStudent = adminStudent.updateStudent(
                dni, name, fatherSurname, motherSurname, direction, date_, active, codeStuden);
        if (responseUpdateStudent==null) {
            return FormatResponse.getErrorResponse("The student error.", 400);
        }
        
        final JsonObject data = new JsonObject();
        data.addProperty("Response", responseUpdateStudent);
        return FormatResponse.getSuccessResponse(data);
    }
*/
}
