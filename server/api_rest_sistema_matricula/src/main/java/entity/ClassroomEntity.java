package entity;

import dto.classroom.ClassroomDTO;
import dto.classroom.ClassroomVacancyDTO;
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
    
    private SectionDTO[] toArraySectionDTOs(ArrayList<HashMap<String, String>> table) {
        final Object[] objArray = EntityHelper.hashMapArrayListToObjArray(
                table, 
                (HashMap<String, String> row) -> getDTOforRowHashMap(row)
        );
        return Arrays.copyOf(objArray, objArray.length, SectionDTO[].class);
    }
    //</editor-fold>
    /*
    public ClassroomVacancyDTO getDetailClassroom(final ClassroomVacancyDTO classroom){
        final Integer codeGrade = classroom.getCode();
        final ArrayList<HashMap<String,String>> table = new ClassroomModel().getDetailClassroom(codeGrade);
        return table.size() > 0 ? getDTOforRowHashMapDetailClassroom(table.get(0)) : null;
    }
    
    private ClassroomVacancyDTO getDTOforRowHashMapDetailClassroom(HashMap<String, String> row) {
        final ClassroomVacancyDTO classroomVacancy = new ClassroomVacancyDTO();
        final ClassroomDTO classroom = new ClassroomDTO();
        final SectionDTO section = new SectionDTO();
        final ShiftDTO Shift= new ShiftDTO();
        final ArrayList<HashMap<String,Object>> table = null;
        section.setCode(Integer.parseInt(row.get("section.code_section")));
        
        return classroomVacancy ;
    }
    
    private ClassroomVacancyDTO[] toArrayDetailsClassroomDTOs(ArrayList<HashMap<String, String>> table) {
        final Object[] objArray = EntityHelper.hashMapArrayListToObjArray(
                table, 
                (HashMap<String, String> row) -> getDTOforRowHashMap(row)
        );
        return Arrays.copyOf(objArray, objArray.length, ClassroomVacancyDTO[].class);
    }*/
}
