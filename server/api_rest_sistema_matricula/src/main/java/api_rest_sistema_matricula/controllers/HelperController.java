package api_rest_sistema_matricula.controllers;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;

public class HelperController {
    // <editor-fold defaultstate="collapsed" desc="Métodos">
    public static void responseToPrint(FormatResponse formatJsonResponse, HttpServletResponse response) 
            throws ServletException, IOException {
        // Agregando headers
        response.addHeader("Access-Control-Allow-Origin", "http://localhost:80");
        // Estableciendo contenido a responder
        response.setContentType("application/json");
        // Respondiendo json body
        final PrintWriter out = response.getWriter();
        out.println(formatJsonResponse.toJsonString(new GsonBuilder())); 
    }
    public static Object fromJsonToInstanceOf(final Reader reader, Class typeClass) {
        return new Gson().fromJson(reader, typeClass);
    }
    // </editor-fold>
}
