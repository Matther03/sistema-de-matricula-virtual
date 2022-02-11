package utils.validation;

public class RegexPatternsValidation {
    public final static String 
        DNI = "^[0-9]{8}$", 
        PASSWORD = "^(?=.*\\d)(?=.*[A-ZÁÉÍÓÚÑ])(?=.*[a-záéíóúñ]).{8,16}$";
}