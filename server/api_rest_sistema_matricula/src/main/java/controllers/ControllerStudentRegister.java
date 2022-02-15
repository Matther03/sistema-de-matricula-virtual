package controllers;

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
public class ControllerStudentRegister extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final AdminEntity adminEntity = new AdminEntity();
        final StudentDTO[] studentRegister = adminEntity.getStudentRegister();
        HelperController.templatePrintable(
                FormatResponse.getSuccessResponse(studentRegister),
                response);
    }
}
