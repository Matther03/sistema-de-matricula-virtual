package entity;

import dto.classroom.SectionDTO;
import dto.classroom.ShiftDTO;
import java.util.ArrayList;
import java.util.HashMap;
import model.ClassroomModel;

public class ClassroomEntity {

    //<editor-fold defaultstate="defaultstate" desc="Action Methods">
    public ArrayList<SectionDTO> getSections() {
        return toArrayListSectionDTOs(new ClassroomModel().getSections());
    }
    //</editor-fold>
    
    //<editor-fold defaultstate="defaultstate" desc="Helpers">
    protected SectionDTO getDTOforRowHashMap(HashMap<String, String> row) {
        return new SectionDTO(
                Integer.parseInt(row.get("CODE_SECTION")),
                row.get("LETTER"),
                new ShiftDTO(
                        Integer.parseInt(row.get("CODE_SHIFT")), 
                        row.get("CATEGORY")
                )
        );
    }
    private ArrayList<SectionDTO> toArrayListSectionDTOs(ArrayList<HashMap<String, String>> table) {
        return new EntityParent<SectionDTO>().hashMapArrayListToDTOArrayList(
                table, 
                (HashMap<String, String> row) -> getDTOforRowHashMap(row)
        );
    }
    //</editor-fold>
}
