package controllers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.student.StudentDTO;
import entity.AdminEntity;
import java.io.IOException;
import java.io.PrintWriter;
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
    final AdminEntity adminEntity = new AdminEntity();
    final Integer parsedLimitTop = adminEntity.isNumber(limitTop);
    if (parsedLimitTop == null) {
        HelperController.templatePrintable(
                FormatResponse.getErrorResponse("Parameter limitTop is not number.", 400) ,
                response);
        return;
    }

    final int intamount = parsedLimitTop + 5;
    final StudentDTO[] registerStudent = adminEntity.getStudentRegister(parsedLimitTop,intamount);

    HelperController.templatePrintable(registerStudent == null?
            FormatResponse.getErrorResponse("Not found", 400):
            FormatResponse.getSuccessResponse(registerStudent),
            response);
    }
}
