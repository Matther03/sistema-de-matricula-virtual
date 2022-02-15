package model;

import database.ProceduresDB;
import java.sql.Connection;
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
}
