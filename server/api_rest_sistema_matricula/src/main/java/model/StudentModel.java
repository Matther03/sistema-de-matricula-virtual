package model;

import database.ConnectionDB;
import database.ProceduresDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import static model.ModelParent.MESSAGE;

public class StudentModel extends ModelParent {
    //<editor-fold defaultstate="default" desc="Access Methods">
    public ArrayList <HashMap<String, String>> getSections() {
        final ConnectionDB cnDB = new ConnectionDB();
        final Connection cnObj = cnDB.connect();
        try {
            final PreparedStatement prSt = cnObj.prepareStatement(ProceduresDB.GET_PASSWORD);
            final ResultSet rs = prSt.executeQuery();
            return getHashMapArrayFrom(rs);
        } catch (SQLException ex) {
            MESSAGE = ex.getMessage();
            return null;
        }
        finally {
            cnDB.disconnect();
        }
    }
    //</editor-fold>
}
