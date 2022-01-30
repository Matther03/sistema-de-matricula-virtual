package entity;

import dto.student.StudentDTO;
import dto.student.AccountDTO;
import java.util.ArrayList;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import utils.Encrypt;
import utils.authentication.JWTAuthentication;
import utils.authentication.RoleAuthJWT;

public class StudentEntity {
    
    public ArrayList<AccountDTO> accounts;
    
    public StudentEntity() {
        accounts = getFakeAccounts();
    }
    
    public String verifyAccount(final AccountDTO accountToLogin, final JWTAuthentication jwtAuth) {
        // 123456780
        final String dni = accountToLogin.getStudent().getIdCard(), password = accountToLogin.getPassword();
        final boolean matched = accounts.stream().anyMatch((AccountDTO account) -> {
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
        return EntityParent.regexIsMatched("^(?=.*\\d)(?=.*[A-ZÁÉÍÓÚÑ])(?=.*[a-záéíóúñ]).{8,16}$", password);
    }
    private boolean isValidDNI(String dni) {
        return EntityParent.regexIsMatched("^[0-9]{8}$", dni);
    }
    private ArrayList<AccountDTO> getFakeAccounts() {
        final ArrayList<AccountDTO> fakeAccounts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setIdCard("12345678" + (i*5));
            String password = "password" + i + (i+3);
            password = Encrypt.doEncrypt(password);
            fakeAccounts.add(new AccountDTO(i + 1, studentDTO, password));
        }
        return fakeAccounts;
    }
}