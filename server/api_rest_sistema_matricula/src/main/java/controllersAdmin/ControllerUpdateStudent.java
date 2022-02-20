package controllersAdmin;

import com.google.gson.JsonObject;
import dto.student.StudentDTO;
import entity.AdminEntity;
import entity.admin.InsertForRegisterEntity;
import java.io.IOException;
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
        if (body == null) 
                return FormatResponse.getErrorResponse("The request body doesn't have json format.", 400);
        
        final StudentDTO student = new StudentDTO();
        final InsertForRegisterEntity insertForRegisterEntity = new InsertForRegisterEntity();
       
        final String msgError = insertForRegisterEntity.validateStudentForUpdate(body, student);
        if (msgError != null) 
            return FormatResponse.getErrorResponse(msgError, 400);
        
        final AdminEntity adminEntity = new AdminEntity();
        
        final Boolean responeUpdateStudent = adminEntity.updateStudent(student);
        if (!responeUpdateStudent) 
            return FormatResponse.getErrorResponse("There is a student with the same DNI", 400);

        return FormatResponse.getSuccessResponse(responeUpdateStudent);   
    }
}
