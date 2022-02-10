package model;

import database.ProceduresDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentModel extends ModelParent {
    
    public ArrayList<HashMap<String, String>> verifyAccount(final String dni) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_PASSWORD);
            prSt.setString(1, dni);
            return prSt;
        });
    }
    
    public ArrayList<HashMap<String, String>> getDetailStudent(final String dni) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_DETAIL_STUDENT);
            prSt.setString(1, dni);
            return prSt;
        });
    }
    
    public ArrayList<HashMap<String, String>> verifyPay(final Integer codeStudent) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_VALUE_PAY);
            prSt.setInt(1, codeStudent);
            return prSt;
        });
    }
    
    public ArrayList<HashMap<String, String>> verifyGrade(final Integer codeStudent) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_VALUE_GRADE);
            prSt.setInt(1, codeStudent);
            return prSt;
        });
    }
}
