
package dto.enrollment;
import dto.classroom.ClassroomDTO;

public class EnrollmentDTO {
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private String date;
    private Boolean repeater;
    private PaymentDTO payment;
    private ClassroomDTO classroom;
    private TypeSchoolDTO typeSChool;
    //</editor-fold>

    public EnrollmentDTO() {
        this.code = null;
        this.classroom = null;
        this.payment= null;
        this.date = null;
        this.typeSChool = null;
        this.repeater= false;
    }

    public EnrollmentDTO(Integer code, String date, Boolean repeater, PaymentDTO payment, ClassroomDTO classroom, TypeSchoolDTO typeSChool) {
        this.code = code;
        this.date = date;
        this.repeater = repeater;
        this.payment = payment;
        this.classroom = classroom;
        this.typeSChool = typeSChool;
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

    public PaymentDTO getPayment() {
        return payment;
    }

    public void setPayment(PaymentDTO payment) {
        this.payment = payment;
    }

    public ClassroomDTO getClassroom() {
        return classroom;
    }

    public void setClassroom(ClassroomDTO classroom) {
        this.classroom = classroom;
    }

    public TypeSchoolDTO getTypeSChool() {
        return typeSChool;
    }

    public void setTypeSChool(TypeSchoolDTO typeSChool) {
        this.typeSChool = typeSChool;
    }
    //</editor-fold>
    
}
