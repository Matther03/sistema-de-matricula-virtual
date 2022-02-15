package database;

public class ProceduresDB {
    
    public static final String GET_PASSWORD = "CALL sp_verify_account_student(?);";
    public static final String GET_DETAIL_CLASSROOM = "CALL sp_get_detail_classroom(?);";
    public static final String GET_DETAIL_STUDENT = "CALL sp_get_detail_student(?);";
    public static final String VERIFY_PAY = "CALL sp_verify_payment_student(?);";
    public static final String VERYFY_GRADE = "CALL sp_verify_grade_student(?);";
    public static final String GET_GRADE_TO_ENROLLMENT = "CALL sp_get_grade_to_enrollment(?);";
    public static final String VERIFY_ENROLL = "CALL sp_verify_enrollment(?);";
    public static final String DO_ENROLLMENT = "CALL sp_do_enrollment(?,?,?);";
    public static final String GET_DETAIL_ENROLLMENT = "CALL sp_get_detail_enrollment(?);";
    //ADMIN
    public static final String GET_REGISTER_STUDENT = "CALL sp_get_register_student(?,?);";
    public static final String GET_REPRESENTATIVE = "CALL sp_get_representative(?);";
}
