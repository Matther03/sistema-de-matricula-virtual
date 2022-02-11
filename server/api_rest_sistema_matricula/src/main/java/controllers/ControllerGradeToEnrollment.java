package controllers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.classroom.GradeDTO;
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

@WebServlet(name = "ControllerGradeToEnrollment", urlPatterns = {"/api/student/grade-to-enrollment"})
public class ControllerGradeToEnrollment extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = gerGradeForEnrollment(body);
        HelperController.templatePrintable(formatResponse, response);
    }   
    
    private FormatResponse gerGradeForEnrollment(final JsonObject body) {
        // Validación del body
        if (body == null)
            return FormatResponse.getErrorResponse("The request body doesn't have json format.", 400);
        final JsonElement codeStudent = body.get("codeStudent");
        if (codeStudent == null) 
            return FormatResponse.getErrorResponse("Mising parameters.", 400);
        
        // Validación del CodeStudent
        final StudentEntity entityStudent = new StudentEntity();        
        
        final Integer codeStudentParsed = entityStudent.isValidCodeStudent(codeStudent.toString());
        if (codeStudentParsed == null){
            return FormatResponse.getErrorResponse("The code student is not valid.", 400);
        }
        
        // Estructura de la respuesta
        final StudentDTO student = new StudentDTO();
        student.setCode(codeStudent.getAsInt());
        final GradeDTO newGrade = entityStudent.getGradeToEnrollment(student);
        
        // Validación del grado
        final boolean grade = entityStudent.isGradeValid(newGrade);
        if (!grade) {
            return FormatResponse.getErrorResponse("The student completed his studies.", 400);
        }
        return FormatResponse.getSuccessResponse(newGrade);
    }
}
