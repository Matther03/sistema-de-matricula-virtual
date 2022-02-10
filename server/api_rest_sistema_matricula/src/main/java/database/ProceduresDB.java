package database;

public class ProceduresDB {
    
    public static final String GET_PASSWORD = "CALL sp_verify_account_student(?);";
    public static final String GET_DETAIL_CLASSROOM = "CALL sp_get_detail_classroom(?);";
    public static final String GET_DETAIL_STUDENT = "CALL sp_get_detail_student(?);";
    public static final String GET_VALUE_PAY = "CALL sp_verify_payment_student(?)";
    public static final String GET_VALUE_GRADE = "CALL sp_verify_grade_student(?)";
    /*
    public static final String GET_PASSWORD_1 = "CALL sp_get_password / sp_verify_account_student(?);";
    */
    
}
