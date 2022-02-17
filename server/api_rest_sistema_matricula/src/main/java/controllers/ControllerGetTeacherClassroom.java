package controllers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.classroom.CourseTeacherDTO;
import dto.classroom.TeacherDTO;
import dto.enrollment.EnrollmentDTO;
import entity.AdminEntity;
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

@WebServlet(name = "ControllerGetTeacherClassroom", urlPatterns = {"/api/student/teacher-classroom"})
public class ControllerGetTeacherClassroom extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = getTeacherClassroom(body);
        HelperController.templatePrintable(formatResponse, response);
    }
    
    private FormatResponse getTeacherClassroom(final JsonObject body) {
        //Validacion del body
        if (body == null)
            return FormatResponse.getErrorResponse("The request body doesn't have json format.", 400);
        final JsonElement codeStudent = body.get("codeStudent");
        if (codeStudent == null) 
            return FormatResponse.getErrorResponse("Mising parameters.", 400);
        
        // Validación del codigo de estudiante
        final StudentEntity entityStudent = new StudentEntity();
        final Integer codeStudentParsed = entityStudent.isValidCodeStudent(codeStudent.toString());
        if (codeStudentParsed == null){
            return FormatResponse.getErrorResponse("The code student is not valid.", 400);
        }
        
        final AdminEntity adminEntity = new AdminEntity();
        final CourseTeacherDTO[] getTeacherClassroom = adminEntity.getTeacherClassroom(codeStudentParsed);
        if (getTeacherClassroom == null) {
            return FormatResponse.getErrorResponse("The student is not enrolled.", 400);
        }
        return FormatResponse.getSuccessResponse(getTeacherClassroom);
    }
}