
package dto.classroom;

public class CourseDTO {
    
     //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private String name;
    private GradeDTO codeGrade;    
    //</editor-fold>

    public CourseDTO() {
        code = null;
        name = null;
        codeGrade = null;
    }

    public CourseDTO(Integer code, String name, GradeDTO codeGrade) {
        this.code = code;
        this.name = name;
        this.codeGrade = codeGrade;
    }
    
     //<editor-fold defaultstate="collapsed" desc="Getters y setters">

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public GradeDTO getCodeGrade() {
        return codeGrade;
    }

    public void setCodeGrade(GradeDTO codeGrade) {
        this.codeGrade = codeGrade;
    }
     //</editor-fold>
    
}
