
package dto.student;

public class StudentDTO {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private String name;
    private String fatherSurname;
    private String motherSurname;
    private Integer age;
    private String dni;
    private String direction;
    private RepresentativeDTO representative;
    //</editor-fold>  

    public StudentDTO(){
    }

    public StudentDTO(Integer code, String name, String fatherSurname, String motherSurname, Integer age, String dni, String direction, RepresentativeDTO representative) {
        this.code = code;
        this.name = name;
        this.fatherSurname = fatherSurname;
        this.motherSurname = motherSurname;
        this.age = age;
        this.dni = dni;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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