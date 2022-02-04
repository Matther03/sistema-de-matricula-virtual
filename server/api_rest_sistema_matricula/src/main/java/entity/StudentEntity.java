package entity;

import dto.student.StudentDTO;
import dto.student.AccountDTO;
import java.util.Arrays;
import utils.Encrypt;
import utils.RegexPatternsValidation;
import utils.authentication.JWTAuthentication;
import utils.authentication.RoleAuthJWT;

public class StudentEntity {
    
    public AccountDTO[] accounts;
    
    public StudentEntity() {
        accounts = getFakeAccounts();
    }
    
    public String verifyAccount(final AccountDTO accountToLogin, final JWTAuthentication jwtAuth) {
        // 123456780
        final String dni = accountToLogin.getStudent().getIdCard(), password = accountToLogin.getPassword();
        final boolean matched = Arrays.stream(accounts).anyMatch((AccountDTO account) -> {
            return account.getStudent().getIdCard().equals(dni) && 
                    Encrypt.matchWithHashedValue(password, account.getPassword());
        });
        if (!matched)
            return null;
        return jwtAuth.getToken(dni, RoleAuthJWT.STUDENT_ROLE);
    } 
    public boolean isValidAccount(final AccountDTO accountToLogin) {
        if (!isValidDNI(accountToLogin.getStudent().getIdCard())) 
            return false;
        return isValidPassword(accountToLogin.getPassword());
    }
    private boolean isValidPassword(final String password) {
        return EntityHelper.regexIsMatched(RegexPatternsValidation.PASSWORD, password);
    }
    private boolean isValidDNI(String dni) {
        return EntityHelper.regexIsMatched(RegexPatternsValidation.DNI, dni);
    }
    private AccountDTO[] getFakeAccounts() {
        final AccountDTO[] fakeAccounts = new AccountDTO[3];
        for (int i = 0; i < 3; i++) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setIdCard("1234567" + i); 
            String password = "Password" + i;
            password = Encrypt.doEncrypt(password);
            fakeAccounts[i] = new AccountDTO(i + 1, studentDTO, password);
        }
        return fakeAccounts;
    }
}