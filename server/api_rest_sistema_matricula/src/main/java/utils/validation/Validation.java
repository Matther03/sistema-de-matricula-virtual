package utils.validation;

import utils.validation.RegexPatternsValidation;
import com.google.gson.JsonObject;
import entity.EntityHelper;
import java.util.regex.Pattern;

public class Validation {
    public static Integer isValidCode(String code, Integer limit) { 
        try {
            Integer codeParsed = Integer.parseInt(code);
            limit = (limit == null ? Integer.MAX_VALUE : limit);
            return codeParsed > 0 &&
                codeParsed <= limit ? codeParsed : null;
        }
        catch (Exception ex) {
            return null;
        }
    }
    public static boolean isValidPassword(final String password) {
        return regexIsMatched(RegexPatternsValidation.PASSWORD, password);
    }
    public static boolean isValidDNI(String dni) {
        return regexIsMatched(RegexPatternsValidation.DNI, dni);
    }
    public static boolean isNullPropertyOfJson(JsonObject jObj, String property) {
        if (!jObj.has(property))
            return true;
        return jObj.get(property).isJsonNull();
    }
    private static boolean regexIsMatched(String regex, final String str) {
        return Pattern.compile(regex).matcher(str).find();
    }
    
}
