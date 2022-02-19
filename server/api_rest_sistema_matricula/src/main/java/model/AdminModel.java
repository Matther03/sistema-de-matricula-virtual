package model;

import database.ProceduresDB;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminModel extends ModelParent {
    
    public ArrayList<HashMap<String, String>> getRegisterStudent(            
        final Integer limitTop,
        final Integer amount){
    return doActionQuery((cnObj, prSt) -> {
        prSt = cnObj.prepareStatement(ProceduresDB.GET_REGISTER_STUDENT);
        prSt.setInt(1, limitTop);
        prSt.setInt(2, amount);
        return prSt;
    });
    }
    
    public ArrayList<HashMap<String, String>> getRepresentative(            
        final Integer codeStudent){
    return doActionQuery((cnObj, prSt) -> {
        prSt = cnObj.prepareStatement(ProceduresDB.GET_REPRESENTATIVE);
        prSt.setInt(1, codeStudent);
        return prSt;
    });
    }
    
    public ArrayList<HashMap<String, String>> getTeacher(            
        final Integer codeStudent){
    return doActionQuery((cnObj, prSt) -> {
        prSt = cnObj.prepareStatement(ProceduresDB.GET_TEACHER);
        prSt.setInt(1, codeStudent);
        return prSt;
    });
    }
    
    public ArrayList<HashMap<String, String>> getTeacherClassroom(            
        final Integer codeStudent){
    return doActionQuery((cnObj, prSt) -> {
        prSt = cnObj.prepareStatement(ProceduresDB.GET_TEACHER_CLASSROOM);
        prSt.setInt(1, codeStudent);
        return prSt;
    });
    }
    
    public ArrayList<HashMap<String, String>> getAmountRegister(){
    return doActionQuery((cnObj, prSt) -> {
        prSt = cnObj.prepareStatement(ProceduresDB.GET_AMOUNT_REGISTER);
        return prSt;
    });
    }
    
    public ArrayList<HashMap<String, String>> updateStudent(
            final String dni,
            final String name,
            final String fatherSurname,
            final String motherSurname,
            final String direction,
            final Date dateOfBirth,
            final Boolean active,
            final Integer codeStudent
    ){
    return doActionQuery((cnObj, prSt) -> {
        prSt = cnObj.prepareStatement(ProceduresDB.UPDATE_STUDENT);
        prSt.setString(1, dni);
        prSt.setString(2, name);
        prSt.setString(3, fatherSurname);
        prSt.setString(4, motherSurname);
        prSt.setString(5, direction);
        prSt.setDate(6, dateOfBirth);
        prSt.setBoolean(7, active);
        prSt.setInt(8, codeStudent);
        return prSt;
    });
    }
    
    public ArrayList<HashMap<String, String>> insertStudent(
            final String name,
            final String fatherSurname,
            final String motherSurname,
            final Date dateOfBirth,
            final String dni,
            final String direction,
            final String dniRepresentative
    ){
    return doActionQuery((cnObj, prSt) -> {
        prSt = cnObj.prepareStatement(ProceduresDB.INSERT_STUDENT);
        prSt.setString(1, name);
        prSt.setString(2, fatherSurname);
        prSt.setString(3, motherSurname);
        prSt.setDate(4, dateOfBirth);
        prSt.setString(5, dni);
        prSt.setString(6, direction);
        prSt.setString(7, dniRepresentative);
        return prSt;
    });
    }
    
    public ArrayList<HashMap<String, String>> insertRepresentative(
            final String name,
            final String fatherSurname,
            final String motherSurname,
            final String dni,
            final String email,
            final String phone
    ){
    return doActionQuery((cnObj, prSt) -> {
        prSt = cnObj.prepareStatement(ProceduresDB.INSERT_REPRESENTATIVE);
            prSt.setString(1, name);
            prSt.setString(2, fatherSurname);
            prSt.setString(3, motherSurname);
            prSt.setString(4, dni);
            prSt.setString(5, email);
            prSt.setString(6, phone);
        return prSt;
    });
    }
}
