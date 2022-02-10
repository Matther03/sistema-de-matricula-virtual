package utils;

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
}
