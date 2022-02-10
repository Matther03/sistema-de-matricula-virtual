package entity;

import com.google.gson.JsonElement;
import database.ProceduresDB;
import dto.classroom.GradeDTO;
import dto.student.StudentDTO;
import dto.student.AccountDTO;
import dto.student.RepresentativeDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import model.StudentModel;
import utils.Encrypt;
import utils.RegexPatternsValidation;
import utils.authentication.JWTAuthentication;
import utils.authentication.RoleAuthJWT;

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
    
    public boolean getValuePay(final StudentDTO student){
        try {
            int codigo = student.getCode();
            final ArrayList<HashMap<String,String>> table = new StudentModel().verifyPay(codigo);
            final String verifyPay = table.get(0).get("RES");
            return Integer.parseInt(verifyPay) == 1;
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean getValueEnroll(final StudentDTO student){
        try {
            int codigo = student.getCode();
            final ArrayList<HashMap<String,String>> table = new StudentModel().verifyEnroll(codigo);
            final String verifyGrade = table.get(0).get("RES");
            return Integer.parseInt(verifyGrade) == 1;
        } catch (Exception e) {
            return false;
        }
    }
    
    public GradeDTO getGradeToEnroLlment(final StudentDTO student){
        int codigo = student.getCode();
        final ArrayList<HashMap<String,String>> table = new StudentModel().gradeToEnrollment(codigo);
        return table.size() > 0 ? getGrade(table.get(0)) : null;
    }
    private GradeDTO getGrade(HashMap<String, String> row) {
        final GradeDTO grade = new GradeDTO();
        grade.setGrade(row.get("RES"));
        return grade;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Helper Methods">
    public boolean isCodeStudentValid(JsonElement codeStudent) {
        try{
            int codigo = Integer.parseInt(codeStudent.toString());
            return codigo>0;
        }catch(Exception e){
        return false;}
    }

    public boolean isValidAccount(final AccountDTO accountToLogin) {
        if (!isValidDNI(accountToLogin.getStudent().getDni())) 
            return false;
        return isValidPassword(accountToLogin.getPassword());
    }
    private boolean isValidPassword(final String password) {
        return EntityHelper.regexIsMatched(RegexPatternsValidation.PASSWORD, password);
    }
    public boolean isValidDNI(String dni) {
        return EntityHelper.regexIsMatched(RegexPatternsValidation.DNI, dni);
    }
    
    public StudentDTO getDetailStudent(final StudentDTO student){
        final String dni = student.getDni();
        final ArrayList<HashMap<String,String>> table = new StudentModel().getDetailStudent(dni);
        return table.size() > 0 ? getDTOforRowHashMap(table.get(0)) : null;
    }

    private StudentDTO getDTOforRowHashMap(HashMap<String, String> row) {
        final StudentDTO student = new StudentDTO();
        student.setCode(Integer.parseInt(row.get("code_student")));
        student.setName(row.get("_name"));
        student.setFatherSurname(row.get("father_surname"));
        student.setMotherSurname(row.get("mother_surname"));
        return student;
    }
    //</editor-fold>
    
}