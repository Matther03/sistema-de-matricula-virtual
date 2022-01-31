
package dto.classroom;

public class ClassroomVacancy {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code, quantity;
    private ClassroomDTO codeClassroom;
    //</editor-fold>

    public ClassroomVacancy() {
        code = null;
        quantity = null;
        codeClassroom = null;
    }

    public ClassroomVacancy(Integer code, Integer quantity, ClassroomDTO codeClassroom) {
        this.code = code;
        this.quantity = quantity;
        this.codeClassroom = codeClassroom;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters y setters">

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public ClassroomDTO getCodeClassroom() {
        return codeClassroom;
    }

    public void setCodeClassroom(ClassroomDTO codeClassroom) {
        this.codeClassroom = codeClassroom;
    }
    //</editor-fold>

    
}
