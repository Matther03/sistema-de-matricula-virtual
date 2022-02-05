package controllers;

import entity.ClassroomEntity;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;

@WebServlet(name = "ControllerStudent", urlPatterns = {"/api/student/details-campus"})
public class ControllerStudent extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HelperController.templatePrintable(
                FormatResponse.getSuccessResponse(new ClassroomEntity().getSections()), response);
    }
}
