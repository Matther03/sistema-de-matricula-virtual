package database;

public class ProceduresDB {
    public static final String GET_ESTUDENTS = "CALL sp_get_dogs(?);";
//reparar falta
    public static final String FIND_STUDENT = "CALL sp_find_dog(?);"; 
    public static final String ADD_DOG = "CALL sp_add_dog(?, ?, ?, ?, ?, ?);";
    public static final String UPDATE_DOG = "CALL sp_update_dog(?, ?, ?, ?, ?, ?, ?);";
    public static final String CARRY_DOG = "CALL sp_carry_dog(?);";  
    
    
    //matricula Procedures
    public static final String GET_PASSWORD = "CALL sp_get_password(?);";
    
}
