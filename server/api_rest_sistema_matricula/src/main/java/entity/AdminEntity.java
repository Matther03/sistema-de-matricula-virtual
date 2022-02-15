package entity;

import dto.enrollment.EnrollmentDTO;
import dto.enrollment.PaymentDTO;
import dto.student.StudentDTO;
import dto.student.RepresentativeDTO;
import java.sql.Date;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import model.AdminModel;

public class AdminEntity {
    
    public StudentDTO[] getStudentRegister(){
        final ArrayList<HashMap<String,String>> table = new  AdminModel().getStudents();
        return table.size() > 0 ? toArrayStudentsDTOs(table) : null;
    }
    private StudentDTO[] toArrayStudentsDTOs(ArrayList<HashMap<String, String>> table) {
        final Object[] objArray = EntityHelper.hashMapArrayListToObjArray(
                table, 
                (HashMap<String, String> row) -> getEnrollmentDTOforRowHashMap(row)
        );
        return Arrays.copyOf(objArray, objArray.length, StudentDTO[].class);
    }
    private StudentDTO getEnrollmentDTOforRowHashMap(HashMap<String, String> row) {
        //final EnrollmentDTO enrollment = new EnrollmentDTO();
        //final PaymentDTO payment = new PaymentDTO();
        
        final StudentDTO student = new StudentDTO();
        student.setCode(Integer.parseInt(row.get("code_student")));
        student.setName(row.get("_name"));
        student.setFatherSurname(row.get("father_surname"));
        student.setMotherSurname(row.get("mother_surname"));
        String str=row.get("date_of_birth");  
        Date date=Date.valueOf(str);
        student.setDateBirth(date.getTime());
        student.setDni(row.get("dni"));
        student.setAddress(row.get("direction"));
            final RepresentativeDTO representative = new RepresentativeDTO();
            representative.setCode(Integer.parseInt(row.get("code_representative")));
            representative.setName(row.get("_name"));
            representative.setFatherSurname(row.get("father_surname"));
            representative.setMotherSurname(row.get("mother_surname"));
            representative.setIdCard(row.get("dni"));
            representative.setEmail(row.get("email"));
            representative.setPhone(row.get("phone"));
        student.setRepresentative(representative);
        
        //payment.setStudent(student);
        //enrollment.setPayment(payment);
        
        return student;
    }    
}
