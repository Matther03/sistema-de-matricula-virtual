package entity;

import com.google.gson.JsonObject;
import utils.delegates.DelegateReturnWithOneParameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class EntityHelper {
    public static Object[] hashMapArrayListToObjArray(
            final ArrayList<HashMap<String, String>> table, 
            final DelegateReturnWithOneParameter<Object, HashMap<String, String>> delegate) {
        return table.stream().map(
                (HashMap<String, String> row) -> { 
                    return delegate.execute(row); 
                }).toArray(Object[]::new);
    }
    public static boolean isNullPropertyOfJson(JsonObject jObj, String property) {
        if (!jObj.has(property))
            return true;
        return jObj.get(property).isJsonNull();
    }
    public static boolean regexIsMatched(String regex, final String str) {
        return Pattern.compile(regex).matcher(str).find();
    }
}
