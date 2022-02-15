
package dto.student;

import java.util.Date;

public class StudentDTO {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private String name;
    private String fatherSurname;
    private String motherSurname;
    private Long dateBirth;
    private String dni;
    private String address;
    private RepresentativeDTO representative;
    //</editor-fold>  

    public StudentDTO(){
    }

    public StudentDTO(Integer code, String name, String fatherSurname, String motherSurname, Long dateBirth, String dni, String address, RepresentativeDTO representative) {
        this.code = code;
        this.name = name;
        this.fatherSurname = fatherSurname;
        this.motherSurname = motherSurname;
        this.dateBirth = dateBirth;
        this.dni = dni;
        this.address = address;
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

    public Long getDateBirth() {
        return dateBirth;
    }

    public void setDateBirth(Long dateBirth) {
        this.dateBirth = dateBirth;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    
    public RepresentativeDTO getRepresentative() {
        return representative;
    }

    public void setRepresentative(RepresentativeDTO representative) {
        this.representative = representative;
    }
    
    //</editor-fold>  

    

}