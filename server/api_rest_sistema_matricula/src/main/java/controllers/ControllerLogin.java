package controllers;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import dto.student.AccountDTO;
import dto.student.StudentDTO;
import entity.StudentEntity;
import utils.FormatResponse;
import utils.HelperController;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.authentication.JWTAuthentication;
import utils.authentication.RoleAuthJWT;

@WebServlet(name = "ControllerLogin", urlPatterns = {"/api/login"})
public class ControllerLogin extends HttpServlet {

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
        HelperController.templatePrintable(verifyAccount(body), response);
    }
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Helpers HTTP methods">
    private FormatResponse verifyAccount(final JsonObject body) {
        if (body == null)
            return FormatResponse.getErrorResponse("The request body doesn't have json format", 400);
        JsonElement dni = body.get("dni"), password = body.get("password");
        if (dni == null || password == null) 
            return FormatResponse.getErrorResponse("Mising parameters", 400);
        
        AccountDTO accountToLogin = new AccountDTO();
        accountToLogin.setPassword(password.getAsString());
        final StudentDTO student = new StudentDTO();
        student.setId_card(dni.getAsString());
        accountToLogin.setStudent(student);
        return FormatResponse.getSuccessResponse(
                new StudentEntity().verifyAccount(accountToLogin));
        /* return FormatResponse.getErrorResponse("User and Password doesn't match", 401);
        JsonObject objToken = new JsonObject();
        objToken.addProperty("token", jwtAuth.getToken(user.getAsString(), RoleAuthJWT.ADMIN_ROLE));
        return FormatResponse.getSuccessResponse(objToken);*/
    }
    //</editor-fold>

}
