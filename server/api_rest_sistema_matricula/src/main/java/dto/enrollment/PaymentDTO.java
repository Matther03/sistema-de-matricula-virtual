
package dto.enrollment;
import dto.student.StudentDTO;

public class PaymentDTO {
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private String date;
    private Double amountPayment;
    private BankDTO codeBanck;
    private StudentDTO codeStudent;
    //</editor-fold>

    public PaymentDTO() {
        this.amountPayment = null;
        this.code = null;
        this.codeBanck = null;
        this.codeStudent = null;
        this.date = null;
    }

    public PaymentDTO(Integer code, String date, Double amountPayment, BankDTO codeBanck, StudentDTO codeStudent) {
        this.code = code;
        this.date = date;
        this.amountPayment = amountPayment;
        this.codeBanck = codeBanck;
        this.codeStudent = codeStudent;
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

    public Double getAmountPayment() {
        return amountPayment;
    }

    public void setAmountPayment(Double amountPayment) {
        this.amountPayment = amountPayment;
    }

    public BankDTO getCodeBanck() {
        return codeBanck;
    }

    public void setCodeBanck(BankDTO codeBanck) {
        this.codeBanck = codeBanck;
    }

    public StudentDTO getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(StudentDTO codeStudent) {
        this.codeStudent = codeStudent;
    }
    //</editor-fold>
    
}
