
package dto.enrollment;

public class RegisterNewStudentDTO {
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private PaymentDTO codePayment;
    //</editor-fold>

    public RegisterNewStudentDTO() {
        this.code = null;
        this.codePayment = null;
    }

    public RegisterNewStudentDTO(Integer code, PaymentDTO codePayment) {
        this.code = code;
        this.codePayment = codePayment;
    }
    
    
    //<editor-fold defaultstate="collapsed" desc="Getters y setters">
    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public PaymentDTO getCodePayment() {
        return codePayment;
    }

    public void setCodePayment(PaymentDTO codePayment) {
        this.codePayment = codePayment;
    }
    //</editor-fold>
    
}
