package controllersAdmin;

import com.google.gson.JsonObject;
import dto.student.ActivationAccountStudentDTO;

import entity.admin.InsertForRegisterEntity;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;

@WebServlet(name = "ControllerDoAccountStudent", urlPatterns = {"/api/student/generate-account"})
public class ControllerDoAccountStudent extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = activeAccountStudent(body,request);
        HelperController.templatePrintable(formatResponse, response);
    }  
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = doAccountStudent(body);
        HelperController.templatePrintable(formatResponse, response);
    }  
    
    private FormatResponse activeAccountStudent(final JsonObject body, final HttpServletRequest request) {
        
        final String token = request.getParameter("token");
        
        if (token == null)
            return FormatResponse.getErrorResponse("Parameter not sent.", 400);

        final InsertForRegisterEntity insertForRegisterEntity = new InsertForRegisterEntity();
        final boolean validToken = insertForRegisterEntity.validateToken(token);
        if (!validToken)
            return FormatResponse.getErrorResponse("The token is not valid.", 400);
        
        final ActivationAccountStudentDTO activationAccountStudent = new ActivationAccountStudentDTO();
        activationAccountStudent.setToken(token);
        final String activeAccount = insertForRegisterEntity.activeAccountStudent(activationAccountStudent);
        if ("ERROR".equals(activeAccount)) 
            return FormatResponse.getErrorResponse("The account is active.", 400);
        return FormatResponse.getSuccessResponse(activeAccount);
        
        
    }
 
    
    private FormatResponse doAccountStudent(final JsonObject body) {
        //Validación del body
        if (body == null) 
                return FormatResponse.getErrorResponse("The request body doesn't have json format.", 400);
        
        final InsertForRegisterEntity insertForRegisterEntity = new InsertForRegisterEntity();
        final ActivationAccountStudentDTO activationAccountStudent = new ActivationAccountStudentDTO();
        
        //Validación de parametros
        final String msgError = insertForRegisterEntity.validateStudentForDoAccountStudent(body, activationAccountStudent);
        if (msgError != null) 
            return FormatResponse.getErrorResponse(msgError, 400);
        
        //Validación de activacion
        final Boolean responseUpdateStudent = insertForRegisterEntity.doAccountStudent(activationAccountStudent);
        if (!responseUpdateStudent) 
            return FormatResponse.getErrorResponse("the student code does not exist", 400);
        return FormatResponse.getSuccessResponse(responseUpdateStudent);
    }
}