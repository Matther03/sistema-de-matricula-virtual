package entity.admin;

import com.google.gson.JsonObject;
import dto.student.RepresentativeDTO;
import dto.student.StudentDTO;
import java.sql.Date;
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
                        !isValidPropertyValueString(jObj.get("phone").getAsString(), 9, 9)))
                return validateRepresentativeErrorMsg("phone");
        }
        catch (NumberFormatException ex) {
            return "Error parsing to number | " + ex.getMessage();
        }
        representative.setName(jObj.get("name").getAsString());
        representative.setFatherSurname(jObj.get("fatherSurname").getAsString());
        representative.setMotherSurname(jObj.get("motherSurname").getAsString());
        representative.setDni(jObj.get("dni").getAsString());
        representative.setEmail(jObj.get("email").getAsString());
        representative.setPhone(jObj.get("phone").getAsString());
        return null;
    }
    
    public String validateStudentForRegister(JsonObject jObj, StudentDTO student) {
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
            if (isNullPropertyOfJson(jObj, "dateOfBirth") ||
                    (!isNullPropertyOfJson(jObj, "dateOfBirth") &&  
                        !isValidPropertyValueDate(jObj.get("dateOfBirth").getAsLong())))
                return validateRepresentativeErrorMsg("dateOfBirth");
            if (isNullPropertyOfJson(jObj, "dni") ||
                    (!isNullPropertyOfJson(jObj, "dni") &&  
                        !isValidPropertyValueString(jObj.get("dni").getAsString(), 8, 8)))
                return validateRepresentativeErrorMsg("dni");
            if (isNullPropertyOfJson(jObj, "address") ||
                    (!isNullPropertyOfJson(jObj, "address") &&  
                        !isValidPropertyValueString(jObj.get("address").getAsString(), 8, 250)))
                return validateRepresentativeErrorMsg("address");
            if (isNullPropertyOfJson(jObj, "dniRepresentative") ||
                    (!isNullPropertyOfJson(jObj, "dniRepresentative") &&  
                        !isValidPropertyValueString(jObj.get("dniRepresentative").getAsString(), 8, 8)))
                return validateRepresentativeErrorMsg("dniRepresentative");
        }
        catch (NumberFormatException ex) {
            return "Error parsing to number | " + ex.getMessage();
        }
        student.setName(jObj.get("name").getAsString());
        student.setFatherSurname(jObj.get("fatherSurname").getAsString());
        student.setMotherSurname(jObj.get("motherSurname").getAsString());
        student.setDateBirth(jObj.get("dateOfBirth").getAsLong());
        student.setDni(jObj.get("dni").getAsString());
        student.setAddress(jObj.get("address").getAsString());
        RepresentativeDTO representative = new RepresentativeDTO();
        representative.setDni(jObj.get("dniRepresentative").getAsString());
        student.setRepresentative(representative);
        return null;
    }
    public String validateStudentForUpdate(JsonObject jObj, StudentDTO student) {
        int quantityNullValues = 0;
        try {
            if (!isNullPropertyOfJson(jObj, "dni") && 
                    !isValidPropertyValueString(jObj.get("dni").getAsString(), 8, 8))
                return validateRepresentativeErrorMsg("dni");
            quantityNullValues = incrementQuantityNullValues("dni", jObj, quantityNullValues);
            if (!isNullPropertyOfJson(jObj, "name") && 
                    !isValidPropertyValueString(jObj.get("name").getAsString(), 1, 50))
                return validateRepresentativeErrorMsg("name");
            quantityNullValues = incrementQuantityNullValues("name", jObj, quantityNullValues);
            if (!isNullPropertyOfJson(jObj, "fatherSurname") && 
                    !isValidPropertyValueString(jObj.get("fatherSurname").getAsString(), 1, 50))
                return validateRepresentativeErrorMsg("fatherSurname");
            quantityNullValues = incrementQuantityNullValues("fatherSurname", jObj, quantityNullValues);
            if (!isNullPropertyOfJson(jObj, "motherSurname") && 
                    !isValidPropertyValueString(jObj.get("motherSurname").getAsString(), 1, 50))
                return validateRepresentativeErrorMsg("motherSurname");
            quantityNullValues = incrementQuantityNullValues("motherSurname", jObj, quantityNullValues);
            if (!isNullPropertyOfJson(jObj, "address") && 
                    !isValidPropertyValueString(jObj.get("address").getAsString(), 1, 50))
                return validateRepresentativeErrorMsg("address");
            quantityNullValues = incrementQuantityNullValues("address", jObj, quantityNullValues);
            if (!isNullPropertyOfJson(jObj, "dateOfBirth") &&
                    !isValidPropertyValueDate(jObj.get("dateOfBirth").getAsLong()))
                return validateRepresentativeErrorMsg("dateOfBirth");
            quantityNullValues = incrementQuantityNullValues("dateOfBirth", jObj, quantityNullValues);
            if (!isNullPropertyOfJson(jObj, "active") &&
                    !isValidPropertyValueBoolean(jObj.get("active").getAsString()))
                return validateRepresentativeErrorMsg("active");
            quantityNullValues = incrementQuantityNullValues("active", jObj, quantityNullValues);
            if (!isNullPropertyOfJson(jObj, "codeStudent") &&
                    !isValidPropertyValueInteger(jObj.get("codeStudent").getAsInt(), 1, null))
                return validateRepresentativeErrorMsg("codeStudent");
        }
        catch (Exception e) {
            return "Parameter is not valid | " + e.getMessage();
        }
        
        if (quantityNullValues == 7)
            return "There is any parameters for update";
        student.setDni(jObj.get("dni").getAsString());
        student.setName(jObj.get("name").getAsString());
        student.setFatherSurname(jObj.get("fatherSurname").getAsString());
        student.setMotherSurname(jObj.get("motherSurname").getAsString());
        student.setAddress(jObj.get("address").getAsString());
        student.setDateBirth(jObj.get("dateOfBirth").getAsLong());
        student.setActive(jObj.get("active").getAsBoolean());
        student.setCode(jObj.get("codeStudent").getAsInt());
        return null;
    }
    public boolean existsId(String idParam) {
        return idParam != null;
    }
    private boolean isValidPropertyValueString(final String value, int limitDown, int limitUp) {
        final int length = value.length();
        return length >= limitDown && length <= limitUp;
    }
    private boolean isValidPropertyValueDate(final Long value) {
        try {
            Date date = new Date(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private boolean isValidPropertyValueBoolean( String value) {
        if ( "1".equals(value))
            return true;
        if ( "0".equals(value))
            return false;
        return false;
    }
    private boolean isValidPropertyValueInteger(int value, Integer limitDown, Integer limitUp) {
        return value >= (limitDown != null ? limitDown : Integer.MIN_VALUE) && 
                value <= (limitUp != null ? limitUp : Integer.MAX_VALUE);
    }
    private int incrementQuantityNullValues(String key, JsonObject jObj, int previousValue) {
        return isNullPropertyOfJson(jObj, key) ? previousValue + 1 : previousValue;
    }
    private String validateRepresentativeErrorMsg(final String noValidParameterName) {
        return "The " + noValidParameterName + " is not a valid parameter.";
    }
}
