
package controllers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.student.StudentDTO;
import entity.StudentEntity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;

@WebServlet(name = "ControllerPaymentStudent", urlPatterns = {"/api/student/detail-payment"})
public class ControllerPaymentStudent extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = verifyPay(body);
        HelperController.templatePrintable(formatResponse, response);
    }
    private FormatResponse verifyPay(final JsonObject body) {
        if (body == null)
            return FormatResponse.getErrorResponse("The request body doesn't have json format.", 400);
        final JsonElement codeStudent = body.get("codeStudent");
        if (codeStudent == null) 
            return FormatResponse.getErrorResponse("Mising parameters", 400);
      final StudentEntity entityStudent = new StudentEntity();
        final boolean studentIsValid = entityStudent.isCodeStudentValid(codeStudent);
        if(!studentIsValid)return FormatResponse.getErrorResponse("The code student is not a number", 400);
                
        //Estructura de la respuesta 
        final StudentDTO student = new StudentDTO();
        student.setCode(codeStudent.getAsInt());
  
        final String valuePay = entityStudent.getValuePay(student);
        body.addProperty("Pay value", valuePay);
        
        return FormatResponse.getSuccessResponse(body);
    }
}
