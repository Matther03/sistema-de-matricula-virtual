package controllers;

import java.io.IOException;
import java.util.Arrays;
import javax.servlet.annotation.WebFilter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.FormatResponse;
import utils.HelperController;
import utils.authentication.JWTAuthentication;
import utils.authentication.RoleAuthJWT;

@WebFilter (filterName="FilterAuthentication", urlPatterns = {"/api/*"})
public class FilterAuthentication implements Filter {
    
    private JWTAuthentication jwtAuth;
    @Override
    public void init(FilterConfig filterConfig) 
            throws ServletException { jwtAuth = new JWTAuthentication(); }

    @Override
    public void doFilter(ServletRequest request, 
            ServletResponse response, FilterChain chain)
        throws IOException, ServletException {
        // Obteniendo ruta actual
        final HttpServletRequest httpRequest = (HttpServletRequest) request;
        if (httpRequest.getMethod().equals("OPTIONS")) {
            ((HttpServletResponse) response).setStatus(HttpServletResponse.SC_OK);
            return;
        }
        final String currentPath = httpRequest.getRequestURI();
        // Continuar si no son las rutas controladores o en la ruta de login
        if (!isPathController(currentPath)) {
            chain.doFilter(request, response);
            return;
        }
        final String token = httpRequest.getHeader("Authorization");
        if (isValidToken(token)) {
            chain.doFilter(request, response);
            return;
        }
        // Restringiendo y respondiendo en caso no haya token
        HelperController.templatePrintable(FormatResponse.getErrorResponse("Unauthorized", 401), (HttpServletResponse) response);
    }

    @Override
    public void destroy() { jwtAuth = null; }
    private boolean isValidToken(String token) {
        if (token == null || !token.startsWith("Bearer ")) 
            return false;
        String tokenWithoutBearer = token.split("Bearer ")[1].trim();
        return jwtAuth.verifyToken(tokenWithoutBearer, RoleAuthJWT.STUDENT_ROLE);
    }
    private boolean isPathController(final String currentPath) {
        return Arrays.stream(ControllerAuthenticationPatterns.STUDENT_PATHS).anyMatch(
                (String PATH) -> currentPath.equals(ControllerAuthenticationPatterns.ROOT + PATH));
    }
}
