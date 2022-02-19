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
        
        final StudentDTO student = new StudentDTO();
        final InsertForRegisterEntity insertForRegisterEntity = new InsertForRegisterEntity();
       
        final String msgError = insertForRegisterEntity.validateStudentForRegister(body, student);
        if (msgError != null) 
            return FormatResponse.getErrorResponse(msgError, 400);
        
        final AdminEntity adminEntity = new AdminEntity();
        
        final Boolean responseInsertStudent = adminEntity.insertStudent(student);
        if (!responseInsertStudent) 
            return FormatResponse.getErrorResponse("There is a student with the same DNI", 400);

        return FormatResponse.getSuccessResponse(responseInsertStudent);
        //TRUE => AGREGADO CON EXITO
    }
}