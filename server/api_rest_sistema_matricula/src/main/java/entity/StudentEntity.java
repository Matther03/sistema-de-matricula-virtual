package entity;

import database.ProceduresDB;
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
    //</editor-fold>
    //<editor-fold defaultstate="collapsed" desc="Helper Methods">
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