package entity.admin;

import dto.student.RepresentativeDTO;
import dto.student.StudentDTO;
import entity.EntityHelper;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import model.AdminModel;

public class GetStudentRegisterEntity {
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
        System.out.println(str);
        Date date=Date.valueOf(str);
        student.setDateBirth(date.getTime());
        student.setDni(row.get("dni"));
        student.setAddress(row.get("direction"));
        return student;
    }    
    //</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Amount Register">
    public Integer getTotalSize() {
        return getAmountRegister();
    }
    
    private Integer getAmountRegister() {
        try {
            final ArrayList<HashMap<String,String>> table = new AdminModel().getAmountRegister();
            final String amount_ = table.get(0).get("RES");
            return Integer.parseInt(amount_);
        } catch (Exception e) {
            return null;
        }
    }
    //</editor-fold>
    
    public Integer isNumberGreaterThanZero(final String numero) {
        try {
            Integer numeroPositivo = Integer.parseInt(numero);
            if (numeroPositivo>0) {
                return numeroPositivo;
            }
            return null;
        } catch (NumberFormatException e) {
        }
        return null;
    }
}
