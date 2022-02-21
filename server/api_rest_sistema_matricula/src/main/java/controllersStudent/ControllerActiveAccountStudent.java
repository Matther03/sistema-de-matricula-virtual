package controllersStudent;

import com.google.gson.JsonElement;
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


@WebServlet(name = "ControllerActiveAccountStudent", urlPatterns = {"/api/student/active"})
public class ControllerActiveAccountStudent extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = activeAccountStudent(body);
        HelperController.templatePrintable(formatResponse, response);
    }  
    
    private FormatResponse activeAccountStudent(final JsonObject body) {
        
        if (body == null) 
                return FormatResponse.getErrorResponse("The request body doesn't have json format.", 400);
       
        final JsonElement token = body.get("token");
        if (token == null) 
            return FormatResponse.getErrorResponse("Mising parameters.", 400);
        
        final InsertForRegisterEntity insertForRegisterEntity = new InsertForRegisterEntity();
        final ActivationAccountStudentDTO activationAccountStudent = new ActivationAccountStudentDTO();
        activationAccountStudent.setToken(token.getAsString());
        final String activeAccount = insertForRegisterEntity.activeAccountStudent(activationAccountStudent);
        if (activeAccount == null) 
            return FormatResponse.getErrorResponse("Error in Active Account.", 400);
        if ("ERROR".equals(activeAccount)) 
            return FormatResponse.getErrorResponse("The account is active.", 400);
        return FormatResponse.getSuccessResponse(activeAccount);
    }
}
