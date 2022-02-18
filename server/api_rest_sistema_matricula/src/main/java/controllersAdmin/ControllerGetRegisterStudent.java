package controllersAdmin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.student.StudentDTO;
import entity.AdminEntity;
import entity.ValidateInput;
import entity.admin.GetStudentRegisterEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;

@WebServlet(name = "ControllerStudentRegister", urlPatterns = {"/api/student/register"})
public class ControllerGetRegisterStudent extends HttpServlet {
    
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    final String limitTop = request.getParameter("limitTop");
    if (limitTop == null){
        HelperController.templatePrintable(
            FormatResponse.getErrorResponse("Parameter not sent.", 400) ,
            response);
        return;
    }
    final GetStudentRegisterEntity getStudentRegisterEntity = new GetStudentRegisterEntity();
    final ValidateInput validateImput = new ValidateInput();
    final Integer parsedLimitTop = validateImput.isNumberGreaterThanZero(limitTop);
    if (parsedLimitTop == null) {
        HelperController.templatePrintable(
            FormatResponse.getErrorResponse("Parameter limitTop is not number valid.", 400) ,
            response);
        return;
    }

    final int amount = 3;
    final int newLimitTop = parsedLimitTop-1;
    final StudentDTO[] registerStudent = getStudentRegisterEntity.getStudentRegister(newLimitTop,amount);
    if (registerStudent == null) {
        HelperController.templatePrintable(
            FormatResponse.getErrorResponse("Not found.", 400) ,
            response);
        return;
    }
    
    final Boolean isEndRows = getStudentRegisterEntity.isEndRows(newLimitTop, amount);
    if (isEndRows == null) {
        HelperController.templatePrintable(
            FormatResponse.getErrorResponse("Unexpected error.", 400) ,
            response);
        return;
    }
    
    final JsonObject data = new JsonObject();
    final Gson gson = new Gson();
        data.addProperty("isEndRows", isEndRows);
        data.add("studentRegister", gson.fromJson(gson.toJson(registerStudent), JsonElement.class));
        
    HelperController.templatePrintable(
        FormatResponse.getSuccessResponse(data),
        response);
    }
}
