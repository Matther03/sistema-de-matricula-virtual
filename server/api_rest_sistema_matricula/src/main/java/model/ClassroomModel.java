package model;

import database.ConnectionDB;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

public class ClassroomModel extends ModelParent {
    
    //<editor-fold defaultstate="default" desc="Access Methods">
    public ArrayList <HashMap<String, String>> getSections() {
        final ConnectionDB cnDB = new ConnectionDB();
        final Connection cnObj = cnDB.connect();
        try {
            final PreparedStatement prSt = cnObj.prepareStatement(
                    "SELECT \n" +
                    "	sec.code_section AS 'CODE_SECTION',\n" +
                    "    sec.letter AS 'LETTER',\n" +
                    "    sh.code_shift AS 'CODE_SHIFT',\n" +
                    "    sh.category AS 'CATEGORY'\n" +
                    "FROM section sec \n" +
                    "INNER JOIN shift sh\n" +
                    "ON sec.code_shift = sh.code_shift;");
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