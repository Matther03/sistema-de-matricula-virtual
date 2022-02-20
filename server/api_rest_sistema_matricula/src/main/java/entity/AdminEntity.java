package entity;

import dto.student.RepresentativeDTO;
import dto.student.StudentDTO;
import java.util.ArrayList;
import java.util.HashMap;
import model.AdminModel;

public class AdminEntity {
    
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
    
    public boolean updateStudent(final StudentDTO student) {
        try {
            ArrayList<HashMap<String, String>> table = new AdminModel().insertStudent(student);
            return "SUCCESS".equals(table.size() > 0 ? table.get(0).get("RES"): null);
        } catch (Exception e) {
            return false;
        }
    }
}
