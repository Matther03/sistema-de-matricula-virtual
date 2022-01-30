package entity;

import com.google.gson.JsonObject;
import utils.delegates.DelegateReturnWithOneParameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Pattern;

public final class EntityParent<T> {
    public ArrayList<T> hashMapArrayListToDTOArrayList(
            final ArrayList<HashMap<String, String>> table, 
            final DelegateReturnWithOneParameter<T, HashMap<String, String>> delegate) {
        ArrayList<T> array = new ArrayList<>();
        table.forEach((HashMap<String, String> row) -> {
            array.add(delegate.Execute(row));
        });
        return array;
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
