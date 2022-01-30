package entity;

import dto.student.StudentDTO;
import dto.student.AccountDTO;
import java.util.ArrayList;
import utils.Encrypt;

public class StudentEntity {
    
    public ArrayList<AccountDTO> accounts;
    
    public StudentEntity() {
        accounts = getFakeAccounts();
    }
    
    public boolean verifyAccount(AccountDTO newAccount) {
        // 123456780
        String dni = newAccount.getStudent().getId_card(), password = newAccount.getPassword();
        return accounts.stream().anyMatch((AccountDTO account) -> {
            return account.getStudent().getId_card().equals(dni) && 
                    Encrypt.matchWithHashedValue(password, account.getPassword());
        });
    }
    
    private ArrayList<AccountDTO> getFakeAccounts() {
        final ArrayList<AccountDTO> fakeAccounts = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            StudentDTO studentDTO = new StudentDTO();
            studentDTO.setId_card("12345678" + (i*5));
            String password = "password" + i + (i+3);
            password = Encrypt.doEncrypt(password);
            fakeAccounts.add(new AccountDTO(i + 1, studentDTO, password));
        }
        return fakeAccounts;
    }
}