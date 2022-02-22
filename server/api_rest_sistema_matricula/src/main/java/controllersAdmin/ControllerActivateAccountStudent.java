
package controllersAdmin;

import com.google.gson.JsonObject;
import dto.student.ActivationAccountStudentDTO;
import dto.student.RepresentativeDTO;
import dto.student.StudentDTO;
import entity.StudentEntity;

import entity.admin.InsertForRegisterEntity;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;
import utils.RandomString;
import utils.email.EmailSender;
import utils.email.EmailTemplate;

@WebServlet(name = "ControllerActivateAccountStudent", urlPatterns = {"/api/student/activate-account"})
public class ControllerActivateAccountStudent extends HttpServlet {
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final FormatResponse formatResponse = activeAccountStudent(request);
        HelperController.templatePrintable(formatResponse, response);
    }  
    
    private FormatResponse activeAccountStudent(final HttpServletRequest request) {
        
        final String token = request.getParameter("token");
        
        if (token == null)
            return FormatResponse.getErrorResponse("Parameter not sent.", 400);

        final InsertForRegisterEntity insertForRegisterEntity = new InsertForRegisterEntity();
        final boolean validToken = insertForRegisterEntity.validateToken(token);
        if (!validToken)
            return FormatResponse.getErrorResponse("The token is not valid.", 400);
        
        final ActivationAccountStudentDTO activeAccount = insertForRegisterEntity.activeAccountStudent(token);
        if (activeAccount == null) 
            return FormatResponse.getErrorResponse("The token doesn't match with any register.", 400);
        
        final int codeStudent = activeAccount.getStudent().getCode();
        final String password = activeAccount.getPlainPassword();
   
        
        final RepresentativeDTO representative = insertForRegisterEntity.getEmailRepresentative(codeStudent);
        //Envio de Token al Representante
        
        final String content = EmailTemplate.getActivatedAccount(password) ;
        final boolean emailSender =new EmailSender().send(representative.getEmail(), "Cuenta Activada", content);
        if (!emailSender)
            return FormatResponse.getErrorResponse("Error sending mail. ", 400);
        
        return FormatResponse.getSuccessResponse(emailSender);
    }
}
