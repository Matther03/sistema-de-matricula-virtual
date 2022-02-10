
package dto.classroom;

public class GradeDTO {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private String grade;
    //</editor-fold>

    public GradeDTO() {
    }

    public GradeDTO(Integer code, String grade) {
        this.code = code;
        this.grade = grade;
    }
    
     //<editor-fold defaultstate="collapsed" desc="Getters y setters">

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
     //</editor-fold>

}
