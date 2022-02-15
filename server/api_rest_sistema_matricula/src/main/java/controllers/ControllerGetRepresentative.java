package controllers;

import dto.student.RepresentativeDTO;
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

@WebServlet(name = "ControllerGetRepresentative", urlPatterns = {"/api/student/representative"})
public class ControllerGetRepresentative extends HttpServlet {
    
protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
    final String codeStudent = request.getParameter("codeStudent");
    if (codeStudent == null){
        HelperController.templatePrintable(
                FormatResponse.getErrorResponse("Parameter not sent.", 400) ,
                response);
        return;
    }
    final AdminEntity adminEntity = new AdminEntity();
    final Integer intcodeStudent = adminEntity.isNumber(codeStudent);
    if (intcodeStudent == null) {
        HelperController.templatePrintable(
                FormatResponse.getErrorResponse("Parameter codeStudent is not number.", 400) ,
                response);
        return;
    }
    
    
    final RepresentativeDTO[] registerStudent = adminEntity.getRepresentative(intcodeStudent);

    HelperController.templatePrintable(registerStudent == null?
            FormatResponse.getErrorResponse("Not found", 400):
            FormatResponse.getSuccessResponse(registerStudent),
            response);
    }
}
