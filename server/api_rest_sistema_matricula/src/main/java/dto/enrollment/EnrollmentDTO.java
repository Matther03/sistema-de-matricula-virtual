
package dto.enrollment;
import dto.classroom.ClassroomDTO;

public class EnrollmentDTO {
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private String date;
    private Boolean repeater;
    private PaymentDTO codePayment;
    private ClassroomDTO codeClassroom;
    private TypeSchoolDTO nameTypeSChool;
    //</editor-fold>

    public EnrollmentDTO() {
        this.code = null;
        this.codeClassroom = null;
        this.codePayment= null;
        this.date = null;
        this.nameTypeSChool = null;
        this.repeater= false;
    }

    public EnrollmentDTO(Integer code, String date, Boolean repeater, PaymentDTO codePayment, ClassroomDTO codeClassroom, TypeSchoolDTO nameTypeSChool) {
        this.code = code;
        this.date = date;
        this.repeater = repeater;
        this.codePayment = codePayment;
        this.codeClassroom = codeClassroom;
        this.nameTypeSChool = nameTypeSChool;
    }
    //<editor-fold defaultstate="collapsed" desc="Getters y setters">

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Boolean getRepeater() {
        return repeater;
    }

    public void setRepeater(Boolean repeater) {
        this.repeater = repeater;
    }

    public PaymentDTO getCodePayment() {
        return codePayment;
    }

    public void setCodePayment(PaymentDTO codePayment) {
        this.codePayment = codePayment;
    }

    public ClassroomDTO getCodeClassroom() {
        return codeClassroom;
    }

    public void setCodeClassroom(ClassroomDTO codeClassroom) {
        this.codeClassroom = codeClassroom;
    }

    public TypeSchoolDTO getNameTypeSChool() {
        return nameTypeSChool;
    }

    public void setNameTypeSChool(TypeSchoolDTO nameTypeSChool) {
        this.nameTypeSChool = nameTypeSChool;
    }
    //</editor-fold>
    
}
