
package controllers;

import com.google.gson.JsonObject;
import utils.FormatResponse;
import utils.HelperController;
import dto.StudentDTO;
import entity.StudentEntity;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.StudentModel;
import org.graalvm.compiler.virtual.phases.ea.PartialEscapeBlockState.Final;

@WebServlet(name = "ControllerStudents", urlPatterns = {"/api/students"})
public class ControllerStudents extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        final StudentEntity dogEntity = new StudentEntity();
        if (getOnlyOneStudent(dogEntity, request, response)) return;
        getAllStudents(dogEntity, request.getParameter("all"), response);
    }
    
    private void getAllStudents(
            final StudentEntity studentEntity,
            final String all, 
            final HttpServletResponse res) 
        throws ServletException, IOException {
        try {
            ArrayList<StudentDTO> Students = studentEntity.getStudents(Boolean.parseBoolean(all));
            HelperController.templatePrintable(
                    FormatResponse.getSuccessResponse(Students), res);
        } catch (IOException | ServletException ex) {
            HelperController.templatePrintable(
                    FormatResponse.getErrorResponse(ex.getMessage(), 400), res);
        }
    }
    private boolean getOnlyOneStudent(
            final StudentEntity studentEntity, 
            final HttpServletRequest req, final HttpServletResponse res) 
        throws ServletException, IOException {
        
        final String idParam = req.getParameter("id");
        // Validando si existe el parametro
        if (studentEntity.existsId(idParam)) {
            // Validado si el parámetro es un valor válido
            if (!studentEntity.isValidId(idParam, (msg) -> {
                HelperController.templatePrintable(                
                        FormatResponse.getErrorResponse(msg, 400), res);
            })) 
               return true;
            
            final StudentDTO studentIn = new StudentDTO();
            studentIn.setId(Integer.parseInt(idParam));
            // Buscando perro
            final StudentDTO studentFound = studentEntity.findStudent(studentIn);
            // Si no existe el perro
            final FormatResponse formatResponse = 
                    (studentFound == null) 
                    ? FormatResponse.getErrorResponse("The dog doesn't exist", 400) 
                    : FormatResponse.getSuccessResponse(studentFound);
            // Imprimiendo respuesta
            HelperController.templatePrintable(formatResponse, res);
            return true;
        }        
        return false;
    }
}
