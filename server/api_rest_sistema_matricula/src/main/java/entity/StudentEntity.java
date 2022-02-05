package entity;

import database.ProceduresDB;
import dto.student.StudentDTO;
import dto.student.AccountDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import model.StudentModel;
import utils.Encrypt;
import utils.RegexPatternsValidation;
import utils.authentication.JWTAuthentication;
import utils.authentication.RoleAuthJWT;

public class StudentEntity {
    
    public String verifyAccount(final AccountDTO accountToLogin, final JWTAuthentication jwtAuth) {
        final String dni = accountToLogin.getStudent().getDni();
        final String password = accountToLogin.getPassword();
        final ArrayList<HashMap<String,String>> table = new StudentModel().getPassword(dni);
        final boolean notExistsAccount = "NOT FOUND".equals(table.get(0).get("ERROR"));
        if (notExistsAccount) 
            return null;
        final String hashedPassword = table.get(0).get("__password");
        final boolean matched = Encrypt.matchWithHashedValue(password, hashedPassword);
        if (!matched)
            return null;
        return jwtAuth.getToken(dni, RoleAuthJWT.STUDENT_ROLE);
    } 
    public boolean isValidAccount(final AccountDTO accountToLogin) {
        if (!isValidDNI(accountToLogin.getStudent().getDni())) 
            return false;
        return isValidPassword(accountToLogin.getPassword());
    }
    private boolean isValidPassword(final String password) {
        return EntityHelper.regexIsMatched(RegexPatternsValidation.PASSWORD, password);
    }
    private boolean isValidDNI(String dni) {
        return EntityHelper.regexIsMatched(RegexPatternsValidation.DNI, dni);
    }
}