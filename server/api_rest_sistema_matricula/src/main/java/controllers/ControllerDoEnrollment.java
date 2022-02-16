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

@WebServlet(name = "ControllerDoEnrollment", urlPatterns = {"/api/student/enrollment"})
public class ControllerDoEnrollment extends HttpServlet {
    
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = doEnrollment(body);
        HelperController.templatePrintable(formatResponse, response);
    }   
    private FormatResponse doEnrollment(final JsonObject body) {
        
        // Validación del body
        if (body == null)
            return FormatResponse.getErrorResponse("The request body doesn't have json format.", 400);
        final JsonElement 
                codeStudent = body.get("codeStudent"),
                codeGrade = body.get("codeGrade"),
                codeSection = body.get("codeSection");
        if (codeStudent == null || codeGrade == null || codeSection == null) 
            return FormatResponse.getErrorResponse("Mising parameters.", 400);
        
        // Validación de ingreso de datos validos
        final StudentEntity entityStudent = new StudentEntity();        

        final Integer codeStudentParsed = entityStudent.isValidCodeStudent(codeStudent.toString());
        final Integer codeGradeParsed = entityStudent.isValidCodeGrade(codeGrade.toString());
        final Integer codeSectionParsed = entityStudent.isValidCodeSection(codeSection.toString());
        
        if (codeStudentParsed == null || codeGradeParsed == null || codeSectionParsed == null){
            return FormatResponse.getErrorResponse("the student data is not valid.", 400);
        }
        
        // Validacion de matriculación
        final StudentDTO student = new StudentDTO();
        student.setCode(codeStudent.getAsInt());
        final boolean canEnroll = entityStudent.canEnrolled(student);
        
        // Control de estudiantes que se pueden matricular y quienes no
        if(!canEnroll){
            return FormatResponse.getErrorResponse("The student cannot enroll.", 400);
        }

        Boolean responseCanEnroll = entityStudent.doEnrollment(codeStudentParsed, codeGradeParsed, codeSectionParsed);
        if (responseCanEnroll==null) {
            return FormatResponse.getErrorResponse("The student does not meet any requirement.", 400);
        }
        
        //Estructura de la respuesta
        final JsonObject data = new JsonObject();
        data.addProperty("enrolled",responseCanEnroll);
                
        return FormatResponse.getSuccessResponse(data);
    }

}