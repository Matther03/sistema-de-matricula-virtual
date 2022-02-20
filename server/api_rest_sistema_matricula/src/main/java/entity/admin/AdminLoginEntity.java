package entity.admin;

import dto.admin.AdminAccountDTO;
import dto.student.AccountDTO;
import java.util.ArrayList;
import java.util.HashMap;
import model.AdminModel;
import model.StudentModel;
import utils.Encrypt;
import static utils.Encrypt.doEncrypt;
import utils.authentication.JWTAuthentication;
import utils.authentication.RoleAuthJWT;
import utils.validation.Validation;

public class AdminLoginEntity {
    
    /*
    public String verifyAccountAdmin(final AdminAccountDTO adminAccount, final JWTAuthentication jwtAuth) {
        final String user = adminAccount.getUser();
        String password = adminAccount.getPassword();
        final String trans = doEncrypt(password);
        adminAccount.setPassword(trans);
        final ArrayList<HashMap<String,String>> table = new AdminModel().verifyAcountAdmin(adminAccount);
        final boolean existsAdmin = "1".equals(table.get(0).get("RES"));
        System.out.println("Respuesta de validacion del procedure:" +existsAdmin);
        if (!existsAdmin){
            return null;}
        return jwtAuth.getToken(user, RoleAuthJWT.ADMIN_ROLE);
    }
    */
    final String testUser = "adminmaurtua", testPassword = "Admin123";
    public String verifyAccount(
            final AdminAccountDTO adminAccount, 
            final JWTAuthentication jwtAuth) {
        final String user = adminAccount.getUser();
        final String password = adminAccount.getPassword();
        final boolean matched = testUser.equals(user) 
                && testPassword.equals(password);
        if (!matched)
            return null;
        return jwtAuth.getToken(user, RoleAuthJWT.ADMIN_ROLE);
    }
    
    public boolean isValidAccount(final AdminAccountDTO adminAccount) {
        return Validation.isValidAdminUser(adminAccount.getUser()) 
                && Validation.isValidPassword(adminAccount.getPassword());
    }
}
