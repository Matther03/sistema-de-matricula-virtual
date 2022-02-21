package controllersAdmin;

import com.google.gson.JsonObject;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;

@WebServlet(name = "ControllerDoAccountStudent", urlPatterns = {"/api/student/account"})
public class ControllerDoAccountStudent extends HttpServlet {

@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        final JsonObject body = HelperController.getRequestBody(request);
        final FormatResponse formatResponse = doAccountStudent(body);
        HelperController.templatePrintable(formatResponse, response);
    }   
    
    private FormatResponse doAccountStudent(final JsonObject body) {
        return FormatResponse.getSuccessResponse(body);
    }
}