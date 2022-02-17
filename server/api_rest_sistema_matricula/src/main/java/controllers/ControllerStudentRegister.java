package controllers;

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
        HelperController.templatePrintable(
                FormatResponse.getSuccessResponse(new AdminEntity().getStudents()), response);
    }
}
