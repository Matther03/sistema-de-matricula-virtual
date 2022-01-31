
package dto.classroom;


public class ClassroomDTO {

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private SectionDTO codeSection;
    private GradeDTO codeGrade;
    private TeacherDTO codeTeacher;
    //</editor-fold>

    public ClassroomDTO() {
        this.code = null;
        this.codeSection = null;
        this.codeGrade = null;
        this.codeTeacher = null;
    }

    public ClassroomDTO(Integer code, SectionDTO codeSection, GradeDTO codeGrade, TeacherDTO codeTeacher) {
        this.code = code;
        this.codeSection = codeSection;
        this.codeGrade = codeGrade;
        this.codeTeacher = codeTeacher;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters y setters">

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public SectionDTO getCodeSection() {
        return codeSection;
    }

    public void setCodeSection(SectionDTO codeSection) {
        this.codeSection = codeSection;
    }

    public GradeDTO getCodeGrade() {
        return codeGrade;
    }

    public void setCodeGrade(GradeDTO codeGrade) {
        this.codeGrade = codeGrade;
    }

    public TeacherDTO getCodeTeacher() {
        return codeTeacher;
    }

    public void setCodeTeacher(TeacherDTO codeTeacher) {
        this.codeTeacher = codeTeacher;
    }
    //</editor-fold>

    
}
