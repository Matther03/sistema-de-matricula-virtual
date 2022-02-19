package entity;

import dto.student.RepresentativeDTO;
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
    
    public String insertRepresentative(final RepresentativeDTO representative) {
        try {
            ArrayList<HashMap<String, String>> table = new AdminModel().insertRepresentative(representative);
            return table.size() > 0 ? table.get(0).get("RES"): null;
        } catch (Exception e) {
            return null;
        }
    }    
    /*public String inserRepresentative(
            final String name,
            final String fatherSurname,
            final String motherSurname,
            final String dni,
            final String email,
            final String phone){
        try {
            final ArrayList<HashMap<String,String>> table = new AdminModel().insertRepresentative(
                name, 
                fatherSurname, 
                motherSurname, 
                dni,
                email,
                phone
            );
            String valueEnroll = table.size() > 0 ? table.get(0).get("RES"): null;
            return  valueEnroll;
        } catch (Exception e) {
            return null;
        }     
    }*/
    
    public String insertStudent(
            final String name,
            final String fatherSurname,
            final String motherSurname,
            final Date dateOfBirth,
            final String dni,
            final String direction,
            final String dniRepresentative){
        try {
            final ArrayList<HashMap<String,String>> table = new AdminModel().insertStudent(
                    name, 
                    fatherSurname, 
                    motherSurname, 
                    dateOfBirth, 
                    dni, 
                    direction, 
                    dniRepresentative);
            String valueEnroll = table.size() > 0 ? table.get(0).get("RES"): null;
            return  valueEnroll;
        } catch (Exception e) {
            return null;
        }     
    }

}
