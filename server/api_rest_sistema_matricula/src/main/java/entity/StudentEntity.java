package entity;

import com.google.gson.JsonObject;
import dto.classroom.ClassroomDTO;
import dto.classroom.GradeDTO;
import dto.classroom.SectionDTO;
import dto.classroom.ShiftDTO;
import dto.enrollment.EnrollmentDTO;
import dto.enrollment.PaymentDTO;
import dto.student.StudentDTO;
import dto.student.AccountDTO;
import java.sql.Date;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import model.StudentModel;
import utils.Encrypt;
import utils.validation.Validation;
import utils.authentication.JWTAuthentication;
import utils.authentication.RoleAuthJWT;
import utils.enums.ResponseEnrollment;

public class StudentEntity {
    
    //<editor-fold defaultstate="collapsed" desc="Action Methods">
    public String verifyAccount(final AccountDTO accountToLogin, final JWTAuthentication jwtAuth) {
        final String dni = accountToLogin.getStudent().getDni();
        final String password = accountToLogin.getPassword();
        final ArrayList<HashMap<String,String>> table = new StudentModel().verifyAccount(dni);
        final String hashedPassword = table.get(0).get("RES");
        final boolean notExistsAccount = "NOT_FOUND".equals(hashedPassword);
        if (notExistsAccount) 
            return null;
        final boolean matched = Encrypt.matchWithHashedValue(password, hashedPassword);
        if (!matched)
            return null;
        return jwtAuth.getToken(dni, RoleAuthJWT.STUDENT_ROLE);
    }
    public EnrollmentDTO getDetailEnrollment(final Integer codigoStudent){
        final ArrayList<HashMap<String,String>> table = new StudentModel().getDetailEnrollment(codigoStudent);
        return table.size() > 0 ? getDTOforDetailEnrollment(table.get(0)) : null;
    }
    
    public StudentDTO getDetailStudent(final StudentDTO student){
        final String dni = student.getDni();
        final ArrayList<HashMap<String,String>> table = new StudentModel().getDetailStudent(dni);
        return table.size() > 0 ? getDTOforRowHashMap(table.get(0)) : null;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Enrollment validation">
    public boolean hasPaid(final StudentDTO student){
        try {
            int codigo = student.getCode();
            final ArrayList<HashMap<String,String>> table = new StudentModel().verifyPay(codigo);
            final String verifyPay = table.get(0).get("RES");
            return Integer.parseInt(verifyPay) == 1;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean verifyGradeEnroll(final StudentDTO student){
        try {
            int codigo = student.getCode();
            final ArrayList<HashMap<String,String>> table = new StudentModel().verifyGradeToEnroll(codigo);
            final String verifyGrade = table.get(0).get("RES");
            return Integer.parseInt(verifyGrade) == 1;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean verifyEnroll(final StudentDTO student){
        try {
            int codigo = student.getCode();
            final ArrayList<HashMap<String,String>> table = new StudentModel().verifyEnroll(codigo);
            final String verifyEnroll = table.get(0).get("RES");
            return Integer.parseInt(verifyEnroll) == 1;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean canEnrolled (final StudentDTO student){
        final boolean paid = hasPaid(student);
        final boolean verifiedEnroll = verifyEnroll(student);
        return paid && verifiedEnroll;
    }
    
    public ResponseEnrollment canEnroll(final StudentDTO student){
        if (!verifyGradeEnroll(student)) 
            return ResponseEnrollment.COMPLETED_STUDIES;
        if (!verifyEnroll(student)) 
            return ResponseEnrollment.ENROLLED;
        if (!hasPaid(student)) 
            return ResponseEnrollment.NO_PAID;
        return ResponseEnrollment.CAN_ENROLL ;
    }
    //</editor-fold>
    
    //Get grade to entollment
    public GradeDTO getGradeToEnrollment(final StudentDTO student){
        int codigo = student.getCode();
        final ArrayList<HashMap<String,String>> table = new StudentModel().gradeToEnrollment(codigo);
        return table.size() > 0 ? getGrade(table.get(0)) : null;
    }
    private GradeDTO getGrade(HashMap<String, String> row) {
        final GradeDTO grade = new GradeDTO();
        grade.setCode(Integer.parseInt(row.get("RES")));
        return grade;
    }
    
    // Boolean para validar si se puede hacer la matricula
    public Boolean doEnrollment(
        final Integer codeStudent,
        final Integer codeGrade,
        final Integer codeSection){
        try {
            final ArrayList<HashMap<String,String>> table = new StudentModel().
                doEnrollment(codeStudent, codeGrade, codeSection);
            String valueEnroll = table.size() > 0 ? table.get(0).get("RES"): null;
            return  "SUCCESSFULLY".equals(valueEnroll);
        } catch (Exception e) {
            return false;
        }     
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Validate Student">
    public Integer isValidCodeStudent(String codeStudent) {
	return Validation.isValidCode(codeStudent, null);
    }
    public Integer isValidCodeGrade(String codeGrade) {
        return Validation.isValidCode(codeGrade, 6);
    }
    public Integer isValidCodeSection(String codeSection) {
        return Validation.isValidCode(codeSection, 7);
    }
    
    // Validación del grado para GradeToEnrollment
    public boolean isGradeValid(final GradeDTO newGrade){
        int grade = newGrade.getCode();
        return grade != 6;
    }

    public boolean isValidAccount(final AccountDTO accountToLogin) {
        if (!Validation.isValidDNI(accountToLogin.getStudent().getDni())) 
            return false;
        return Validation.isValidPassword(accountToLogin.getPassword());
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Helper Methods">
    private StudentDTO getDTOforRowHashMap(HashMap<String, String> row) {
        final StudentDTO student = new StudentDTO();
        student.setCode(Integer.parseInt(row.get("code_student")));
        student.setName(row.get("_name"));
        student.setFatherSurname(row.get("father_surname"));
        student.setMotherSurname(row.get("mother_surname"));
        return student;
    }
    
     private EnrollmentDTO getDTOforDetailEnrollment(HashMap<String, String> row){
        final EnrollmentDTO enrollment = new EnrollmentDTO();

        final StudentDTO student = new StudentDTO();
        student.setName(row.get("_name"));
        student.setFatherSurname(row.get("father_surname"));
        student.setMotherSurname(row.get("mother_surname"));
        student.setDni(row.get("dni"));
        final PaymentDTO payment= new PaymentDTO();
        payment.setCode(Integer.parseInt(row.get("code_payment")));
        final ClassroomDTO classroom = new ClassroomDTO();
        final GradeDTO grade = new GradeDTO();
        grade.setName(row.get("name_grade"));
        final ShiftDTO shift = new ShiftDTO();
        shift.setCategory(row.get("category"));
        final SectionDTO section = new SectionDTO();
        section.setLetter(row.get("letter"));
        section.setShift(shift);
        classroom.setGrade(grade);
        classroom.setSection(section);
        payment.setStudent(student);
        enrollment.setPayment(payment); //name-apellidos- apelidos -dni-codigo de pago
        enrollment.setCode(Integer.parseInt(row.get("code_enrollment")));//codigo de matricula
        String str=row.get("date_enrollment");  
        Date date=Date.valueOf(str);
        enrollment.setDate(date.getTime());
        enrollment.setClassroom(classroom); //grado-letra-seccion
        return enrollment;
    }
    //</editor-fold>
    
}