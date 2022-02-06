package controllers;

import dto.classroom.ClassroomVacancyDTO;
import dto.classroom.GradeDTO;
import entity.ClassroomEntity;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;


@WebServlet(name = "ControllerDetailsClassroom", urlPatterns = {"/api/student/details-classroom"})
public class ControllerDetailsClassroom extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
            
        final String codeGrade = request.getParameter("codeGrade");
        if (codeGrade == null){
            HelperController.templatePrintable(
                    FormatResponse.getErrorResponse("Code grade not sent.", 400) ,
                    response);
            return;
        }
        final ClassroomEntity classroomEntity = new ClassroomEntity();
        if (!classroomEntity.isValidCodeGrade(codeGrade)) {
            HelperController.templatePrintable(
                        FormatResponse.getErrorResponse("Code grade is not valid.", 400) ,
                        response);
            return;
        }
        final GradeDTO grade = new GradeDTO();
        grade.setCode(Integer.parseInt(codeGrade));
        final ClassroomVacancyDTO classroomVacancy = classroomEntity.getDetailClassroom(grade);
        HelperController.templatePrintable(
                classroomVacancy == null?
                FormatResponse.getErrorResponse("Code grade is not found.", 400):
                FormatResponse.getSuccessResponse(classroomVacancy),
                response);
    }
}