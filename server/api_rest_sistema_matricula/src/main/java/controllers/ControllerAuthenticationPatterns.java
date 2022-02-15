package controllers;

public class ControllerAuthenticationPatterns {
    public static String[] STUDENT_PATHS = {
        "/student/detail-campus", //get ?dni=12345678 
        "/student/detail-classroom", 
        "/student/enrollment",
        "/student/can-enroll",
        "/student/grade-to-enrollment",
        
        "/student/register"
        
    };
    public static String[] ADMIN_PATHS = {
        "/student/register",
        "/"
    };
    public static String ROOT = "/api_rest_sistema_matricula/api";
}
