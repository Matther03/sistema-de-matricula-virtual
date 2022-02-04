package entity;

import dto.classroom.SectionDTO;
import dto.classroom.ShiftDTO;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import model.ClassroomModel;

public class ClassroomEntity {

    //<editor-fold defaultstate="defaultstate" desc="Action Methods">
    public SectionDTO[] getSections() {
        return toArraySectionDTOs(new ClassroomModel().getSections());
    }
    //</editor-fold>
    //<editor-fold defaultstate="defaultstate" desc="Helpers">
    private SectionDTO getDTOforRowHashMap(HashMap<String, String> row) {
        return new SectionDTO(
                Integer.parseInt(row.get("CODE_SECTION")),
                row.get("LETTER"),
                new ShiftDTO(
                        Integer.parseInt(row.get("CODE_SHIFT")), 
                        row.get("CATEGORY")
                )
        );
    }
    private SectionDTO[] toArraySectionDTOs(ArrayList<HashMap<String, String>> table) {
        final Object[] objArray = EntityHelper.hashMapArrayListToObjArray(
                table, 
                (HashMap<String, String> row) -> getDTOforRowHashMap(row)
        );
        return Arrays.copyOf(objArray, objArray.length, SectionDTO[].class);
    }
    //</editor-fold>
}
