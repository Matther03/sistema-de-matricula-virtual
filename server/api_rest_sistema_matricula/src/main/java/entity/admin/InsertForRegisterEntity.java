package entity.admin;

import com.google.gson.JsonObject;
import dto.student.RepresentativeDTO;
import static utils.validation.Validation.isNullPropertyOfJson;

public class InsertForRegisterEntity {
    
    public String validateRepresentativeForRegister(JsonObject jObj, RepresentativeDTO representative) {
        try {
            if (isNullPropertyOfJson(jObj, "name") ||
                    (!isNullPropertyOfJson(jObj, "name") &&  
                        !isValidPropertyValueString(jObj.get("name").getAsString(), 1, 50)))
                return validateRepresentativeErrorMsg("name");
            if (isNullPropertyOfJson(jObj, "fatherSurname") ||
                    (!isNullPropertyOfJson(jObj, "fatherSurname") &&  
                        !isValidPropertyValueString(jObj.get("fatherSurname").getAsString(), 1, 100)))
                return validateRepresentativeErrorMsg("fatherSurname");
            if (isNullPropertyOfJson(jObj, "motherSurname") ||
                    (!isNullPropertyOfJson(jObj, "motherSurname") &&  
                        !isValidPropertyValueString(jObj.get("motherSurname").getAsString(), 1, 100)))
                return validateRepresentativeErrorMsg("motherSurname");
            if (isNullPropertyOfJson(jObj, "dni") ||
                    (!isNullPropertyOfJson(jObj, "dni") &&  
                        !isValidPropertyValueString(jObj.get("dni").getAsString(), 8, 8)))
                return validateRepresentativeErrorMsg("dni");
            if (isNullPropertyOfJson(jObj, "email") ||
                    (!isNullPropertyOfJson(jObj, "email") &&  
                        !isValidPropertyValueString(jObj.get("email").getAsString(), 8, 50)))
                return validateRepresentativeErrorMsg("email");
            if (isNullPropertyOfJson(jObj, "phone") ||
                    (!isNullPropertyOfJson(jObj, "phone") &&  
                        !isValidPropertyValueString(jObj.get("phone").getAsString(), 6, 12)))
                return validateRepresentativeErrorMsg("phone");
        }
        catch (NumberFormatException ex) {
            return "Error parsing to number | " + ex.getMessage();
        }
        representative.setName(jObj.get("name").getAsString());
        representative.setFatherSurname(jObj.get("fatherSurname").getAsString());
        representative.setMotherSurname(jObj.get("motherSurname").getAsString());
        representative.setIdCard(jObj.get("dni").getAsString());
        representative.setEmail(jObj.get("email").getAsString());
        representative.setPhone(jObj.get("phone").getAsString());
        return null;
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
    private String validateRepresentativeErrorMsg(final String noValidParameterName) {
        return "The " + noValidParameterName + " is not a valid parameter.";
    }
}
