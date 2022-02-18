package entity.admin;

import dto.admin.AdminAccountDTO;
import utils.authentication.JWTAuthentication;
import utils.authentication.RoleAuthJWT;
import utils.validation.Validation;

public class AdminLoginEntity {
    
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
