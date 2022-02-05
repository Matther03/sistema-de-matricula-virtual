package controllers;

public class ControllerAuthenticationPatterns {
    public static String[] STUDENT_PATHS = {
        "/student/details-campus", //get ?dni=12345678 
        "/student/enrollment"
    };
    public static String[] ADMIN_PATHS = {
        "/student/register"
    };
    public static String ROOT = "/api_rest_sistema_matricula/api";
}
