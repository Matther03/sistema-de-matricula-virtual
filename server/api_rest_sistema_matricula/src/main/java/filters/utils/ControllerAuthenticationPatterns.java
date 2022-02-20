package filters.utils;

public class ControllerAuthenticationPatterns {
    public static String[] STUDENT_PATHS = {
        "/student/detail-campus", //get ?dni=12345678 
        "/student/detail-classroom",
        "/student/detail-enrollment",
        "/student/enrollment",
        "/student/can-enroll",
        "/student/grade-to-enrollment"
    };
    public static String[] ADMIN_PATHS = {
        "/student/register",
        "/student/sections",
        "/student/representative",
        "/student/update"
    };
    public static String ROOT = "/api_rest_sistema_matricula/api";
}
