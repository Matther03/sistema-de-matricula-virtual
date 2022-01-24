
package model;

import database.ConnectionDB;
import database.ProceduresDB;
import dto.StudentDTO;
import java.util.HashMap;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

public class StudentModel extends ModelParent{
    
    public ArrayList<HashMap<String, String>> getStudents(boolean all) {
        final ConnectionDB cnDB = new ConnectionDB();
        final Connection cnObj = cnDB.connect();
        try {
            final PreparedStatement prSt = cnObj.prepareStatement(ProceduresDB.GET_ESTUDENTS);
            prSt.setBoolean(1, all);
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
    public HashMap<String, String> findStudent(final int id) {
        final ConnectionDB cnDB = new ConnectionDB();
        final Connection cnObj = cnDB.connect();
        try {
            final PreparedStatement prSt = cnObj.prepareStatement(ProceduresDB.FIND_STUDENT);
            prSt.setInt(1, id);
            final ResultSet rs = prSt.executeQuery();
            return getHashMapFrom(rs);
        }
        catch (SQLException ex) {
            MESSAGE = ex.getMessage();
            return null;
        }
        finally {
            cnDB.disconnect();
        }
    }
}
