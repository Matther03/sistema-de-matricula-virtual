package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminModel extends ModelParent {
    
        public ArrayList<HashMap<String, String>> getStudents() {
        return doActionQuery((Connection cnObj, PreparedStatement prSt) -> {
            prSt = cnObj.prepareStatement(
                    "SELECT * FROM student"+ /*s INNER JOIN representative r ON s.code_representative=r.code_representative*/"; ");
            return prSt;
        });
    }
}
