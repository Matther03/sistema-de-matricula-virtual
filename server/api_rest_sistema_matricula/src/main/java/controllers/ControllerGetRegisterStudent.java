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
    final String amount = request.getParameter("amount");
    if (limitTop == null || amount == null){
        HelperController.templatePrintable(
                FormatResponse.getErrorResponse("Parameter not sent.", 400) ,
                response);
        return;
    }
    final AdminEntity adminEntity = new AdminEntity();
    final Integer intLimitTop = adminEntity.isNumber(limitTop);
    if (intLimitTop == null) {
        HelperController.templatePrintable(
                FormatResponse.getErrorResponse("Parameter limitTop is not number.", 400) ,
                response);
        return;
    }
    final Integer intamount = adminEntity.isNumber(amount);
    if (intamount == null) {
        HelperController.templatePrintable(
                FormatResponse.getErrorResponse("Parameter amount is not number.", 400) ,
                response);
        return;
    }
    
    final StudentDTO[] registerStudent = adminEntity.getStudentRegister(intLimitTop,intamount);

    HelperController.templatePrintable(registerStudent == null?
            FormatResponse.getErrorResponse("Not found", 400):
            FormatResponse.getSuccessResponse(registerStudent),
            response);
    }
}
