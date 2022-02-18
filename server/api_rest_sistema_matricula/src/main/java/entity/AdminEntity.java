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
    
    //<editor-fold defaultstate="collapsed" desc="Representative">
    public RepresentativeDTO[] getRepresentative(final Integer codeStudent){
        final ArrayList<HashMap<String,String>> table = new  AdminModel().getRepresentative(codeStudent);
        return table.size() > 0 ? toArrayRepresentativeDTOs(table) : null;
    }
    private RepresentativeDTO[] toArrayRepresentativeDTOs(ArrayList<HashMap<String, String>> table) {
        final Object[] objArray = EntityHelper.hashMapArrayListToObjArray(
                table, 
                (HashMap<String, String> row) -> getRepresentativeDTOforRowHashMap(row)
        );
        return Arrays.copyOf(objArray, objArray.length, RepresentativeDTO[].class);
    }
    private RepresentativeDTO getRepresentativeDTOforRowHashMap(HashMap<String, String> row) {
        final RepresentativeDTO representative = new RepresentativeDTO();
            representative.setName(row.get("_name"));
            representative.setFatherSurname(row.get("father_surname"));
            representative.setMotherSurname(row.get("mother_surname"));
            representative.setIdCard(row.get("dni"));
            representative.setEmail(row.get("email"));
            representative.setPhone(row.get("phone"));
        return representative;
    }    
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Student Register">
    public StudentDTO[] getStudentRegister(final Integer limitTop, final Integer amount){
        final ArrayList<HashMap<String,String>> table = new  AdminModel().getRegisterStudent(limitTop, amount);
        return table.size() > 0 ? toArrayStudentsDTOs(table) : null;
    }
    private StudentDTO[] toArrayStudentsDTOs(ArrayList<HashMap<String, String>> table) {
        final Object[] objArray = EntityHelper.hashMapArrayListToObjArray(
                table, 
                (HashMap<String, String> row) -> getregisterStudentDTOforRowHashMap(row)
        );
        return Arrays.copyOf(objArray, objArray.length, StudentDTO[].class);
    }
    private StudentDTO getregisterStudentDTOforRowHashMap(HashMap<String, String> row) {
        final StudentDTO student = new StudentDTO();
        student.setCode(Integer.parseInt(row.get("code_student")));
        student.setName(row.get("_name"));
        student.setFatherSurname(row.get("father_surname"));
        student.setMotherSurname(row.get("mother_surname"));
        String str=row.get("date_of_birth");  
        Date date=Date.valueOf(str);
        student.setDateBirth(date.getTime());
        student.setDni(row.get("dni"));
        student.setAddress(row.get("direction"));
        return student;
    }    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Amount Register">
    public Boolean isEndRows (final Integer limitTop, final Integer amount){
        final Integer amountRegister = getAmountRegister();
        if (amountRegister == null) return null;
        return limitTop + amount >= amountRegister;
    }
    
    private Integer getAmountRegister(){
        try {
            final ArrayList<HashMap<String,String>> table = new AdminModel().getAmountRegister();
            final String amount_ = table.get(0).get("RES");
            return Integer.parseInt(amount_);
        } catch (Exception e) {
            return null;
        }
    }
    //</editor-fold>
    
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
    
    //<editor-fold defaultstate="collapsed" desc="Get Teacher">
    public TeacherDTO getTeacher(final Integer codeStudent){
        final ArrayList<HashMap<String,String>> table = new AdminModel().getTeacher(codeStudent);
        return table.size() > 0 ? getTeacherDTOforRowHashMap(table.get(0)) : null;
    }
    
    private TeacherDTO getTeacherDTOforRowHashMap(HashMap<String, String> row) {
        final TeacherDTO teacher = new TeacherDTO();
        teacher.setName(row.get("_name"));
        teacher.setFatherSurname(row.get("father_surname"));
        teacher.setMotherSurname(row.get("mother_surname"));
        return teacher;
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="collapsed" desc="Get Teacher Classroom">
    public CourseTeacherDTO[] getTeacherClassroom(final Integer codeStudent){
        final ArrayList<HashMap<String,String>> table = new AdminModel().getTeacherClassroom(codeStudent);
        return table.size() > 0 ? toArrayTeacherClassroomDTOs(table) : null;
    }
    
    private CourseTeacherDTO[] toArrayTeacherClassroomDTOs(ArrayList<HashMap<String, String>> table) {
        final Object[] objArray = EntityHelper.hashMapArrayListToObjArray(
                table, 
                (HashMap<String, String> row) -> getTeacherClassroomDTOforRowHashMap(row)
        );
        return Arrays.copyOf(objArray, objArray.length, CourseTeacherDTO[].class);
    }
        
    private CourseTeacherDTO getTeacherClassroomDTOforRowHashMap(HashMap<String, String> row) {
        final CourseTeacherDTO courseTeacher = new CourseTeacherDTO();
        final CourseDTO course = new CourseDTO();
            course.setName(row.get("name_course"));
        courseTeacher.setCourse(course);
        final TeacherDTO teacher = new TeacherDTO();
            teacher.setName(row.get("_name"));
            teacher.setFatherSurname(row.get("father_surname"));
            teacher.setMotherSurname(row.get("mother_surname"));
        courseTeacher.setTeacher(teacher);
        return courseTeacher;
    }
    //</editor-fold>
    
    public Integer isNumberGreaterThanZero(final String parameter){
        try {
            final Integer number = Integer.parseInt(parameter);
            if (number>0) 
                return number;
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    
    public boolean isValidAccount(final AdminAccountDTO adminAccount) {
        return Validation.isValidAdminUser(adminAccount.getUser()) 
                && Validation.isValidPassword(adminAccount.getPassword());
    }
}
