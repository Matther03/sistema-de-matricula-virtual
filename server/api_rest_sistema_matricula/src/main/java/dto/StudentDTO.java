
package dto;

import java.util.ArrayList;
import java.util.HashMap;

public class StudentDTO {
    //<editor-fold defaultstate="collapsed" desc="Testeo bd">  
    //<editor-fold defaultstate="collapsed" desc="Properties">
    private Integer id;
    private RaceDogDTO raceDog;
    private SizeDogDTO sizeDog;
    private String name, description, owner;
    private Double weight;
    private Boolean carried;
    //</editor-fold>

    public StudentDTO() {
        this.id = 0;
        this.raceDog = new RaceDogDTO();
        this.sizeDog = new SizeDogDTO();
        this.name = "";
        this.description = "";
        this.owner = "";
        this.weight = 0.0;
        this.carried = false;
    }

    public StudentDTO(Integer id, RaceDogDTO raceDog, SizeDogDTO sizeDog, 
            String name, String description, String owner, 
            Double weight, Boolean carried) {
        this.id = id;
        this.raceDog = raceDog;
        this.sizeDog = sizeDog;
        this.name = name;
        this.description = description;
        this.owner = owner;
        this.weight = weight;
        this.carried = carried;
    }
    
    //<editor-fold defaultstate="collapsed" desc="Getters and Setters">   
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    
    public RaceDogDTO getRaceDog() {
        return raceDog;
    }

    public void setRaceDog(RaceDogDTO raceDog) {
        this.raceDog = raceDog;
    }

    public SizeDogDTO getSizeDog() {
        return sizeDog;
    }

    public void setSizeDog(SizeDogDTO sizeDog) {
        this.sizeDog = sizeDog;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Boolean isCarried() {
        return carried;
    }

    public void setCarried(Boolean carried) {
        this.carried = carried;
    }
    //</editor-fold>
    //</editor-fold> 
 
    
    
    
    //<editor-fold defaultstate="collapsed" desc="Students">  
    /*
    private Integer id;
    private String name;
    private String father_surname;
    private String mother_surname;
    private Integer age;
    private Integer id_card;
    private String direction;
    private Integer code_representative;
    
    public StudentDTO(){
        this.id=0;
        this.name="";
        this.father_surname="";
        this.mother_surname="";
        this.age=0;
        this.id_card=0;
        this.direction="";
        this.code_representative=0;
    }
    
    public StudentDTO(Integer id,String name,String father_surname,String mother_surname,
            Integer age,Integer id_card,String direction,Integer code_representative){
        this.id=id;
        this.name=name;
        this.father_surname=father_surname;
        this.mother_surname=mother_surname;
        this.age=age;
        this.id_card=id_card;
        this.direction=direction;
        this.code_representative=code_representative;
    }

    public StudentDTO(int parseInt, String get, String get0, String get1, double parseDouble, boolean equals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public StudentDTO(int parseInt, String get, String get0, String get1, int parseInt0, double parseDouble, boolean equals) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
//<editor-fold defaultstate="collapsed" desc="Getters and Setters">  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFather_surname() {
        return father_surname;
    }

    public void setFather_surname(String father_surname) {
        this.father_surname = father_surname;
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

    public Integer getId_card() {
        return id_card;
    }

    public void setId_card(Integer id_card) {
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
    //</editor-fold> 
  
    
    */

}
