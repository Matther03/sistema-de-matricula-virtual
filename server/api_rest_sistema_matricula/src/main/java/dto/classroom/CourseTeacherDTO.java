
package dto.classroom;

public class CourseTeacherDTO {

    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private TeacherDTO codeTeacher;
    private CourseDTO codeCourse;
    //</editor-fold>

    public CourseTeacherDTO() {
        this.code = null;
        this.codeTeacher = null;
        this.codeCourse = null;
    }

    public CourseTeacherDTO(Integer code, TeacherDTO codeTeacher, CourseDTO codeCourse) {
        this.code = code;
        this.codeTeacher = codeTeacher;
        this.codeCourse = codeCourse;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters y setters">

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public TeacherDTO getCodeTeacher() {
        return codeTeacher;
    }

    public void setCodeTeacher(TeacherDTO codeTeacher) {
        this.codeTeacher = codeTeacher;
    }

    public CourseDTO getCodeCourse() {
        return codeCourse;
    }

    public void setCodeCourse(CourseDTO codeCourse) {
        this.codeCourse = codeCourse;
    }
    
    //</editor-fold>
    
    
}
