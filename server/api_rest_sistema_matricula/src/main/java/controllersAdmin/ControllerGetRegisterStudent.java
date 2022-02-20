package controllersAdmin;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.student.StudentDTO;
import entity.admin.GetStudentRegisterEntity;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;

@WebServlet(name = "ControllerStudentRegister", urlPatterns = {"/api/student/register"})
public class ControllerGetRegisterStudent extends HttpServlet {
    
@Override
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    final String limitTop = request.getParameter("limitTop"),
                seeSize = request.getParameter("seeSize");
    
    boolean seeSizeValue = Boolean.parseBoolean(seeSize);
    
    if (limitTop == null){
        HelperController.templatePrintable(
            FormatResponse.getErrorResponse("Parameter not sent.", 400) ,
            response);
        return;
    }
    final GetStudentRegisterEntity getStudentRegisterEntity = new GetStudentRegisterEntity();
    final Integer parsedLimitTop = getStudentRegisterEntity.isNumberGreaterThanZero(limitTop);
    if (parsedLimitTop == null) {
        HelperController.templatePrintable(
            FormatResponse.getErrorResponse("Parameter limitTop is not number valid.", 400) ,
            response);
        return;
    }

    final int amount = 3;
    final int newLimitTop = parsedLimitTop-1;

    final StudentDTO[] students = getStudentRegisterEntity.getStudentRegister(newLimitTop,amount);
    if (students == null) {
        HelperController.templatePrintable(
            FormatResponse.getErrorResponse("Not found.", 400) ,
            response);
        return;
    }
    
    final JsonObject data = new JsonObject();
    System.out.println(seeSizeValue);
    if (seeSizeValue) {
        final Integer totalSize = getStudentRegisterEntity.getTotalSize();
        if (totalSize == null) {
            HelperController.templatePrintable(
                FormatResponse.getErrorResponse("Unexpected error.", 400) ,
                response);
            return;
        }
        data.addProperty("totalSize", totalSize);
    }
    
    data.add("students", HelperController.toJsonElement(students, new Gson()) ) ;
        
    HelperController.templatePrintable(
        FormatResponse.getSuccessResponse(data),
        response);
    }
}