package model;

import database.ProceduresDB;
import dto.student.RepresentativeDTO;
import dto.student.StudentDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

public class AdminModel extends ModelParent {
    
    public ArrayList<HashMap<String, String>> getRegisterStudent(            
        final Integer limitTop,
        final Integer amount) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_REGISTER_STUDENT);
            prSt.setInt(1, limitTop);
            prSt.setInt(2, amount);
            return prSt;
        });
    }
    
    public ArrayList<HashMap<String, String>> getRepresentative(            
        final Integer codeStudent) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_REPRESENTATIVE);
            prSt.setInt(1, codeStudent);
            return prSt;
        });
    }
    
    public ArrayList<HashMap<String, String>> getTeacher(            
        final Integer codeStudent) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_TEACHER);
            prSt.setInt(1, codeStudent);
            return prSt;
        });
    }
    
    public ArrayList<HashMap<String, String>> getTeacherClassroom(            
        final Integer codeStudent) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_TEACHER_CLASSROOM);
            prSt.setInt(1, codeStudent);
            return prSt;
        });
    }
    
    public ArrayList<HashMap<String, String>> getAmountRegister(){
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.GET_AMOUNT_REGISTER);
            return prSt;
        });
    }
    
    public ArrayList<HashMap<String, String>> updateStudent(
            final String dni,
            final String name,
            final String fatherSurname,
            final String motherSurname,
            final String direction,
            final Date dateOfBirth,
            final Boolean active,
            final Integer codeStudent) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.UPDATE_STUDENT);
            prSt.setString(1, dni);
            prSt.setString(2, name);
            prSt.setString(3, fatherSurname);
            prSt.setString(4, motherSurname);
            prSt.setString(5, direction);
            prSt.setDate(6, dateOfBirth);
            prSt.setBoolean(7, active);
            prSt.setInt(8, codeStudent);
            return prSt;
        });
    }
    
    public ArrayList<HashMap<String, String>> insertStudent(
            final StudentDTO student) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.INSERT_STUDENT);
                prSt.setString(1, student.getName());
                prSt.setString(2, student.getFatherSurname());
                prSt.setString(3, student.getMotherSurname());
                prSt.setDate(4, new Date(student.getDateBirth()));
                prSt.setString(5, student.getDni());
                prSt.setString(6, student.getAddress());
                prSt.setString(7, student.getRepresentative().getIdCard());
                System.out.println(new Date(student.getDateBirth()));
            return prSt;

        });
    }
    
    public ArrayList<HashMap<String, String>> insertRepresentative(
            final RepresentativeDTO representative) {
        return doActionQuery((cnObj, prSt) -> {
            prSt = cnObj.prepareStatement(ProceduresDB.INSERT_REPRESENTATIVE);
                prSt.setString(1, representative.getName());
                prSt.setString(2, representative.getFatherSurname());
                prSt.setString(3, representative.getMotherSurname());
                prSt.setString(4, representative.getIdCard());
                prSt.setString(5, representative.getEmail());
                prSt.setString(6, representative.getPhone());
            return prSt;
        });
    }
}
