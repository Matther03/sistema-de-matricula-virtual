package entity;

import dto.classroom.SectionDTO;
import dto.classroom.ShiftDTO;
import dto.student.RepresentativeDTO;
import dto.student.StudentDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import model.ClassroomModel;

public class ClassroomEntity {

    //<editor-fold defaultstate="defaultstate" desc="Action Methods">
    public SectionDTO[] getSections() {
        return toArraySectionDTOs(new ClassroomModel().getSections());
    }
    
    public StudentDTO[] getStudents() {
        return toArrayStudentDTOs(new ClassroomModel().getStudents());
    }
    //</editor-fold>
    //<editor-fold defaultstate="defaultstate" desc="Helpers">
    private SectionDTO getDTOforRowHashMap(HashMap<String, String> row) {
        return new SectionDTO(
                Integer.parseInt(row.get("CODE_SECTION")),
                row.get("LETTER"),
                new ShiftDTO(
                        Integer.parseInt(row.get("CODE_SHIFT")), 
                        row.get("CATEGORY")
                )
        );
    }
    
    private StudentDTO getStudentDTOforRowHashMap(HashMap<String, String> row) {
        return new StudentDTO(
                Integer.parseInt(row.get("CODE_STUDENT")),
                row.get("NAME"),
                row.get("FATHER SURNAME"),
                row.get("MOTHER SURNAME"),
                Integer.parseInt(row.get("AGE")),
                row.get("DNI"),
                row.get("DIRECCION"),
                new RepresentativeDTO(
                        Integer.parseInt(row.get("CODE_REPRESENTATIVE")),
                        row.get("NAME"),
                        row.get("FATHER SURNAME"),
                        row.get("MOTHER SURNAME"),
                        row.get("DNI"),
                        row.get("EMAIL"),
                        row.get("PHONE")
                )
        );
    }
    
    
    private SectionDTO[] toArraySectionDTOs(ArrayList<HashMap<String, String>> table) {
        final Object[] objArray = EntityHelper.hashMapArrayListToObjArray(
                table, 
                (HashMap<String, String> row) -> getDTOforRowHashMap(row)
        );
        return Arrays.copyOf(objArray, objArray.length, SectionDTO[].class);
    }
    
    private StudentDTO[] toArrayStudentDTOs(ArrayList<HashMap<String, String>> table) {
        final Object[] objArray = EntityHelper.hashMapArrayListToObjArray(
                table, 
                (HashMap<String, String> row) -> getStudentDTOforRowHashMap(row)
        );
        return Arrays.copyOf(objArray, objArray.length, StudentDTO[].class);
    }
    //</editor-fold>
}
