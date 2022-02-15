package entity;

import dto.classroom.ClassroomDTO;
import dto.classroom.ClassroomVacancyDTO;
import dto.classroom.GradeDTO;
import dto.classroom.SectionDTO;
import dto.classroom.ShiftDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import model.ClassroomModel;

public class ClassroomEntity {

    //<editor-fold defaultstate="defaultstate" desc="Action Methods">
    public SectionDTO[] getSections() {
        return toArraySectionDTOs(new ClassroomModel().getSections());
    }
    public ClassroomVacancyDTO getDetailClassroom(final GradeDTO grade){
        final int codeGrade = grade.getCode();
        final ArrayList<HashMap<String,String>> table = new ClassroomModel().getDetailClassroom(codeGrade);
        return table.size() > 0 ? getDTOforRowHashMapDetailClassroom(table.get(0)) : null;
    }
    private ClassroomVacancyDTO getDTOforRowHashMapDetailClassroom(HashMap<String, String> row) {
        final ClassroomVacancyDTO classroomVacancy = new ClassroomVacancyDTO();
        final ClassroomDTO classroom = new ClassroomDTO();
        final GradeDTO grade = new GradeDTO();
        grade.setName(row.get("name_grade"));
        final ShiftDTO shift = new ShiftDTO();
        shift.setCategory(row.get("category"));
        final SectionDTO section = new SectionDTO(
                Integer.parseInt(row.get("code_section")),
                row.get("letter"),
                shift
        );
        classroom.setGrade(grade);
        classroom.setSection(section);
        classroomVacancy.setClassroom(classroom);
        classroomVacancy.setQuantity(Integer.parseInt(row.get("quantity")));

        return classroomVacancy ;
    }
    //</editor-fold>
    //<editor-fold defaultstate="defaultstate" desc="Helper Methods">
    public boolean isValidCodeGrade(String codeGrade) {
        try {
            final int parseCodeGrade = Integer.parseInt(codeGrade);
            return parseCodeGrade > 0 && parseCodeGrade <= 5;
        }
        catch (NumberFormatException ex) {
            return false;
        }
    }
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

}
