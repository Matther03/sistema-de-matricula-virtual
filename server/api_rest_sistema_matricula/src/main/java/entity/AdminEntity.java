package entity;

import dto.enrollment.EnrollmentDTO;
import dto.enrollment.PaymentDTO;
import dto.student.StudentDTO;
import dto.student.RepresentativeDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import model.AdminModel;

public class AdminEntity {
    
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
    
    public Integer isNumber(final String parameter){
        try {
            return Integer.parseInt(parameter);
        } catch (Exception e) {
            return null;
        }
    }
}
