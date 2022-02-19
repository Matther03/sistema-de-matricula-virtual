package controllersAdmin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.student.RepresentativeDTO;
import dto.student.StudentDTO;
import entity.AdminEntity;
import entity.StudentEntity;
import entity.admin.InsertForRegisterEntity;
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
        
        final RepresentativeDTO representative = new RepresentativeDTO();
        final InsertForRegisterEntity insertForRegisterEntity = new InsertForRegisterEntity();
       
        final String msgError = insertForRegisterEntity.validateRepresentativeForRegister(body, representative);
        if (msgError != null) 
            return FormatResponse.getErrorResponse(msgError, 400);
        
        final AdminEntity adminEntity = new AdminEntity();
        final String responseInsertRepresentative = adminEntity.insertRepresentative(representative);
        if (!"SUCCESS".equals(responseInsertRepresentative)) 
            return FormatResponse.getErrorResponse("There is a representative with the same DNI", 400);

        return FormatResponse.getSuccessResponse(responseInsertRepresentative);
    }
}
