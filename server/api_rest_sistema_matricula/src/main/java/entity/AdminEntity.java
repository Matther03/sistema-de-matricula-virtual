package entity;

import dto.admin.AdminAccountDTO;
import dto.classroom.CourseDTO;
import dto.classroom.CourseTeacherDTO;
import dto.classroom.TeacherDTO;
import dto.student.StudentDTO;
import dto.student.RepresentativeDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import model.AdminModel;
import utils.authentication.JWTAuthentication;
import utils.authentication.RoleAuthJWT;
import utils.validation.Validation;

public class AdminEntity {
    
    //<editor-fold defaultstate="collapsed" desc="Update Student">
    public boolean updateStudent(
            final String dni,
            final String name,
            final String fatherSurname,
            final String motherSurname,
            final String direction,
            final String dateOfBirth,
            final Boolean active,
            final Integer codeStudent
        ){
        try {
            final ArrayList<HashMap<String,String>> 
            table = new AdminModel().updateStudent(
                dni, 
                name, 
                fatherSurname, 
                motherSurname, 
                direction, 
                dateOfBirth, 
                active, 
                codeStudent
            );
            final String updateStudent = table.get(0).get("RES");
            return Integer.parseInt(updateStudent) == 1;
        } catch (Exception e) {
            return false;
        }
    }
    //</editor-fold>

}
