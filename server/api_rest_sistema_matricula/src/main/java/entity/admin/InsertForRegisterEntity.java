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
        representative.setIdCard(jObj.get("dni").getAsString());
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
        representative.setIdCard(jObj.get("dniRepresentative").getAsString());
        student.setRepresentative(representative);
        return null;
    }
    public boolean existsId(String idParam) {
        return idParam != null;
    }
    private boolean isValidPropertyValueString(String value, int limitDown, int limitUp) {
        final int length = value.length();
        return length >= limitDown && length <= limitUp;
    }
    private boolean isValidPropertyValueDate(Long value) {
        try {
            Date date = new Date(value);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    private String validateRepresentativeErrorMsg(final String noValidParameterName) {
        return "The " + noValidParameterName + " is not a valid parameter.";
    }
}
