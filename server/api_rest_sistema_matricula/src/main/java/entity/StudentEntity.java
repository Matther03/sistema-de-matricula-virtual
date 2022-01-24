
package entity;


import com.google.gson.JsonObject;
import dto.RaceDogDTO;
import dto.SizeDogDTO;
import dto.StudentDTO;
import java.io.IOException;
import model.StudentModel;
import java.util.ArrayList;
import java.util.HashMap;
import javax.servlet.ServletException;
import utils.delegates.DelegateVoidOneParamThrowsServletAndIOException;

public class StudentEntity extends EntityParent<StudentDTO>{
    
    public ArrayList<StudentDTO> getStudents(boolean all) {
        return toArrayList(new StudentModel().getStudents(all));
    }
     public StudentDTO findStudent(final StudentDTO studentDTO) {
        HashMap<String, String> row = new StudentModel().findStudent(studentDTO.getId());
        return row.size() <= 0 ? null : getDTOforRowHashMap(row);
    }
    
    @Override
    protected StudentDTO getDTOforRowHashMap(HashMap<String, String> row) {
        return new StudentDTO(
                Integer.parseInt(row.get("ID")),
                new RaceDogDTO(
                        Integer.parseInt(row.get("ID_RACE_DOG")), 
                        row.get("RACE_DOG")),
                new SizeDogDTO(
                        Integer.parseInt(row.get("ID_SIZE_DOG")), 
                        row.get("SIZE_DOG")), 
                row.get("NAME"),
                row.get("DESCRIPTION"),
                row.get("OWNER"),
                Double.parseDouble(row.get("WEIGHT")), 
                row.get("CARRIED").equals("1")
        );
    }
    
    
    
    private ArrayList<StudentDTO> toArrayList(ArrayList<HashMap<String, String>> table) {
        return hashMapArrayListToDTOArrayList(
                table, 
                (HashMap<String, String> row) ->  getDTOforRowHashMap(row)
        );
    }
    
    
    public boolean isValidId(final String idParam, DelegateVoidOneParamThrowsServletAndIOException<String> doError) throws ServletException, IOException {
        try {
            final int id = Integer.parseInt(idParam);
            if (id <= 0)
                isValidIdErrorMessage(doError, idParam);
            return id > 0;
        }
        catch (NumberFormatException ex) {
            isValidIdErrorMessage(doError, idParam);
            return false;
        }
    }
    public boolean existsId(String idParam) {
        return idParam != null;
    }
    private boolean isValidPropertyValueString(String value, int limitDown, int limitUp) {
        final int length = value.length();
        return length >= limitDown && length <= limitUp;
    }
    private boolean isValidPropertyValueInteger(int value, Integer limitDown, Integer limitUp) {
        return value >= (limitDown != null ? limitDown : Integer.MIN_VALUE) && 
                value <= (limitUp != null ? limitUp : Integer.MAX_VALUE);
    }
    private boolean isValidPropertyValueDouble(double value, Double limitDown, Double limitUp) {
        return value >= (limitDown != null ? limitDown : Double.MIN_VALUE) && 
                value <= (limitUp != null ? limitUp : Double.MAX_VALUE);
    }
    private int incrementQuantityNullValues(String key, JsonObject jObj, int previousValue) {
        return isNullPropertyOfJson(jObj, key) ? previousValue + 1 : previousValue;
    }
    private void isValidIdErrorMessage(DelegateVoidOneParamThrowsServletAndIOException<String> doError, String idParam) throws ServletException, IOException {
        doError.Execute("Id " +idParam +" is not valid number");
    }
    private String validateDogFromAddOrUpdateErrorMsg(final String noValidParameterName) {
        return "The " + noValidParameterName + " is not a valid parameter.";
    }
    
    
    /*
    @Override
    protected StudentDTO getDTOforRowHashMap(HashMap<String, String> row) {
         return new StudentDTO(
                Integer.parseInt(row.get("ID")),
                row.get("NAME"),
                row.get("FATHER_SURNAME"),
                row.get("MOTHER_SURNAME"),
                Integer.parseInt(row.get("AGE")),
                Integer.parseInt(row.get("ID_CARD")),
                row.get("DIRECCION"),
                Integer.parseInt(row.get("CODE_REPRESENTATIVE"))
        );
    }
    */
}
