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
            final String dateOfBirth,
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
        prSt.setString(6, dateOfBirth);
        prSt.setBoolean(7, active);
        prSt.setInt(8, codeStudent);
        return prSt;
    });
    }
}
