package model;

import java.util.ArrayList;
import java.util.HashMap;

public class ClassroomModel extends ModelParent {
    
    //<editor-fold defaultstate="default" desc="Access Methods">
    public ArrayList<HashMap<String, String>> getSections() {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(
                    "SELECT \n" +
                    "	sec.code_section AS 'CODE_SECTION',\n" +
                    "    sec.letter AS 'LETTER',\n" +
                    "    sh.code_shift AS 'CODE_SHIFT',\n" +
                    "    sh.category AS 'CATEGORY'\n" +
                    "FROM section sec \n" +
                    "INNER JOIN shift sh\n" +
                    "ON sec.code_shift = sh.code_shift;");
            return prSt;
        });
    }
    //</editor-fold>
}