
package dto.student;

public class StudentDTO {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private String name;
    private String fatherSurname;
    private String motherSurname;
    private Integer age;
    private String idCard;
    private String direction;
    private RepresentativeDTO representative;
    //</editor-fold>  

    public StudentDTO(){
        this.code = null;
        this.name = null;
        this.fatherSurname = null;
        this.motherSurname = "";
        this.age = 0;
        this.idCard = null;
        this.direction = null;
        this.representative = null;
    }

    public StudentDTO(Integer code, String name, String fatherSurname, String motherSurname, Integer age, String idCard, String direction, RepresentativeDTO representative) {
        this.code = code;
        this.name = name;
        this.fatherSurname = fatherSurname;
        this.motherSurname = motherSurname;
        this.age = age;
        this.idCard = idCard;
        this.direction = direction;
        this.representative = representative;
    }
    

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">  
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }
    
    public RepresentativeDTO getRepresentative() {
        return representative;
    }

    public void setRepresentative(RepresentativeDTO representative) {
        this.representative = representative;
    }
    
    //</editor-fold>  

    

}