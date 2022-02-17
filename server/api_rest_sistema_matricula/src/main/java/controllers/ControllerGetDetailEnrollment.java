package controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.classroom.CourseTeacherDTO;
import dto.classroom.TeacherDTO;
import dto.enrollment.EnrollmentDTO;
import dto.student.StudentDTO;
import entity.AdminEntity;
import entity.StudentEntity;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;

@WebServlet(name = "ControllerGetDetailEnrollment", urlPatterns = {"/api/student/detail-enrollment"})
public class ControllerGetDetailEnrollment extends HttpServlet {
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = getDetailEnrollent(body);
        HelperController.templatePrintable(formatResponse, response);
    }
    
    private FormatResponse getDetailEnrollent(final JsonObject body) {
        //Validacion del body
        if (body == null)
            return FormatResponse.getErrorResponse("The request body doesn't have json format.", 400);
        final JsonElement codeStudent = body.get("codeStudent");
        if (codeStudent == null) 
            return FormatResponse.getErrorResponse("Mising parameters.", 400);

        final StudentEntity entityStudent = new StudentEntity();
        final AdminEntity adminEntity = new AdminEntity();
        
        // Validación del codigo de estudiante
        final Integer codeStudentParsed = entityStudent.isValidCodeStudent(codeStudent.toString());
        if (codeStudentParsed == null){
            return FormatResponse.getErrorResponse("The code student is not valid.", 400);
        }
        
        //Detalle de Matricula
        final EnrollmentDTO detailEnrollment = entityStudent.getDetailEnrollment(codeStudentParsed);
        //Obetener Tutor
        final TeacherDTO teacher = adminEntity.getTeacher(codeStudentParsed);
        //Obtener profesores por salón
        final CourseTeacherDTO[] classroomTeachers = adminEntity.getTeacherClassroom(codeStudentParsed);
        
        //Respuesta de error
        if (detailEnrollment == null || teacher == null || classroomTeachers == null ) {
            return FormatResponse.getErrorResponse("The student is not enrolled.", 400);
        }

        //Estructurar Respuesta
        final JsonObject data = new JsonObject();
        final Gson gson = new GsonBuilder().setPrettyPrinting().create();
        
        data.addProperty("detailEnrollment", gson.toJson(detailEnrollment));
        data.addProperty("teacher", gson.toJson(teacher));
        data.addProperty("classroomTeachers", gson.toJson(classroomTeachers));
        
        return FormatResponse.getSuccessResponse(data);
    }
}
