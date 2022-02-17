package controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.student.StudentDTO;
import entity.AdminEntity;
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
    final AdminEntity adminEntity = new AdminEntity();
    final Integer parsedLimitTop = adminEntity.isNumber(limitTop);
    if (parsedLimitTop == null) {
        HelperController.templatePrintable(
            FormatResponse.getErrorResponse("Parameter limitTop is not number.", 400) ,
            response);
        return;
    }

    final int amount = 3;
    
    final StudentDTO[] registerStudent = adminEntity.getStudentRegister(parsedLimitTop,amount);
    if (registerStudent == null) {
        HelperController.templatePrintable(
            FormatResponse.getErrorResponse("Not found.", 400) ,
            response);
        return;
    }
    /* 
    
    final Boolean isEndRows = adminEntity.isEndRows(parsedLimitTop, amount);
    if (isEndRows == null) {
        HelperController.templatePrintable(
            FormatResponse.getErrorResponse("Unexpected error.", 400) ,
            response);
        return;
    }
    
    
    final JsonObject data = new JsonObject();
    data.addProperty("isEndRows", isEndRows);
    

    */
    HelperController.templatePrintable(
        FormatResponse.getSuccessResponse(registerStudent),
        response);
    }
}
