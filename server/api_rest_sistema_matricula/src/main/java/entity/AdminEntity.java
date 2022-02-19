package entity;

import dto.student.RepresentativeDTO;
import dto.student.StudentDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import model.AdminModel;

public class AdminEntity {
    
    //<editor-fold defaultstate="collapsed" desc="Update Student">
    public String updateStudent(
            final String dni,
            final String name,
            final String fatherSurname,
            final String motherSurname,
            final String direction,
            final Date dateOfBirth,
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
            return table.get(0).get("RES");
            
        } catch (Exception e) {
            return "noo";
        }
    }
    
    public Boolean studentUpdate(
        final String dni,
            final String name,
            final String fatherSurname,
            final String motherSurname,
            final String direction,
            final Date dateOfBirth,
            final Boolean active,
            final Integer codeStudent){
        try {
            final ArrayList<HashMap<String,String>> table = new AdminModel().updateStudent(
                dni, 
                name, 
                fatherSurname, 
                motherSurname, 
                direction, 
                dateOfBirth, 
                active, 
                codeStudent
            );
            String valueEnroll = table.size() > 0 ? table.get(0).get("RES"): null;
            return  "SUCCESSFULLY".equals(valueEnroll);
        } catch (Exception e) {
            return false;
        }     
    }
    //</editor-fold>
    
    public boolean insertRepresentative(final RepresentativeDTO representative) {
        try {
            ArrayList<HashMap<String, String>> table = new AdminModel().insertRepresentative(representative);
            return "SUCCESS".equals(table.size() > 0 ? table.get(0).get("RES"): null);
        } catch (Exception e) {
            return false;
        }
    }
    
    public boolean insertStudent(final StudentDTO student) {
        try {
            ArrayList<HashMap<String, String>> table = new AdminModel().insertStudent(student);
            return "SUCCESS".equals(table.size() > 0 ? table.get(0).get("RES"): null);
        } catch (Exception e) {
            return false;
        }
    }
}
