package model;

import database.ProceduresDB;
import java.util.ArrayList;
import java.util.HashMap;

public class StudentModel extends ModelParent {
    
    //<editor-fold defaultstate="default" desc="Access Methods">
    public ArrayList<HashMap<String, String>> getSections() {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_PASSWORD);
            return prSt;
        });
    }
    //</editor-fold>
    public ArrayList<HashMap<String, String>> getPassword(final String dni) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_PASSWORD);
            prSt.setString(1, dni);
            return prSt;
        });
    }
}
