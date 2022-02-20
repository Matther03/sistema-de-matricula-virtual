package controllersAdmin;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.admin.AdminAccountDTO;
import entity.admin.AdminLoginEntity;
import utils.FormatResponse;
import utils.HelperController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.authentication.JWTAuthentication;

@WebServlet(name = "ControllerLoginAdmin", urlPatterns = {"/api/admin/login"})
public class ControllerLoginAdmin extends HttpServlet {

    private JWTAuthentication jwtAuth;
    @Override
    public void init() { jwtAuth = new JWTAuthentication(); }
    @Override
    public void destroy() {  jwtAuth = null; }
    //<editor-fold defaultstate="collapsed" desc="HTTP Methods">
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = verifyAccount(body);
        HelperController.templatePrintable(formatResponse, response);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Helpers HTTP methods">
    private FormatResponse verifyAccount(final JsonObject body) {
        // Validando respuesta
        if (body == null)
            return FormatResponse.getErrorResponse("The request body doesn't have json format", 400);
        final JsonElement user = body.get("user"), password = body.get("password");
        if (user == null || password == null) 
            return FormatResponse.getErrorResponse("Mising parameters", 400);
        
        // Armando dto para verificar cuenta
        final AdminAccountDTO accountToLogin = new AdminAccountDTO(
                user.getAsString(), 
                password.getAsString()
        );
        final AdminLoginEntity adminLoginEntity = new AdminLoginEntity();
        final boolean isValid = adminLoginEntity.isValidAccount(accountToLogin);
        if (!isValid)
            return FormatResponse.getErrorResponse("The parameters body aren't valid.", 400);

        // Verificando cuenta de estudiante
        final String token = adminLoginEntity.verifyAccount(accountToLogin, jwtAuth);
        // Mostrando error de no coincidir
        if (token == null)
            return FormatResponse.getErrorResponse("The account credentials don't match.", 401);
        // Respondiendo token
        final JsonObject objToken = new JsonObject();
        objToken.addProperty("token", token);
        return FormatResponse.getSuccessResponse(objToken);
    }
    //</editor-fold>

}