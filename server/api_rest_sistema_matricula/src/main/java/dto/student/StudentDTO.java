
package dto.student;

public class StudentDTO {
    
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer code;
    private String name;
    private String fatherSurname;
    private String mother_surname;
    private Integer age;
    private String id_card;
    private String direction;
    private Integer code_representative;
    //</editor-fold>  

    public StudentDTO(){
        this.code = null;
        this.name = null;
        this.fatherSurname = null;
        this.mother_surname = "";
        this.age = 0;
        this.id_card = null;
        this.direction = null;
        this.code_representative = 0;
    }

    public StudentDTO(Integer code, String name, String father_surname, String mother_surname, Integer age, String id_card, String direction, Integer code_representative) {
        this.code = code;
        this.name = name;
        this.fatherSurname = father_surname;
        this.mother_surname = mother_surname;
        this.age = age;
        this.id_card = id_card;
        this.direction = direction;
        this.code_representative = code_representative;
    }
    

    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">  
    public Integer getId() {
        return code;
    }

    public void setId(Integer code) {
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

    public void setFather_surname(String father_surname) {
        this.fatherSurname = father_surname;
    }

    public String getMother_surname() {
        return mother_surname;
    }

    public void setMother_surname(String mother_surname) {
        this.mother_surname = mother_surname;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getIdCard() {
        return id_card;
    }

    public void setIdCard(String id_card) {
        this.id_card = id_card;
    }

    public String getDirection() {
        return direction;
    }

    public void setDirection(String direction) {
        this.direction = direction;
    }

    public Integer getCode_representative() {
        return code_representative;
    }

    public void setCode_representative(Integer code_representative) {
        this.code_representative = code_representative;
    }
    //</editor-fold>  

}