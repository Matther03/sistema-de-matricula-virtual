package dto.student;

public class RepresentativeDTO {
    
     //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private String name, fatherSurname, motherSurname, idCard, email,phone;
    //</editor-fold>

    public RepresentativeDTO() {
        this.code = null;
        this.name = null;
        this.fatherSurname = null;
        this.motherSurname = null;
        this.idCard = null;
        this.email = null;
        this.phone = null;
    }

    public RepresentativeDTO(Integer code, String name, String fatherSurname, String motherSurname, String idCard, String email, String phone) {
        this.code = code;
        this.name = name;
        this.fatherSurname = fatherSurname;
        this.motherSurname = motherSurname;
        this.idCard = idCard;
        this.email = email;
        this.phone = phone;
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

    public String getFatherSurname() {
        return fatherSurname;
    }

    public void setFatherSurname(String fatherSurname) {
        this.fatherSurname = fatherSurname;
    }

    public String getMotherSurname() {
        return motherSurname;
    }

    public void setMotherSurname(String motherSurname) {
        this.motherSurname = motherSurname;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
       //</editor-fold>
}
