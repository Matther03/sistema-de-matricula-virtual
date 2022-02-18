package entity;

import dto.classroom.GradeDTO;
import java.sql.Date;
import utils.validation.RegexPatternsValidation;
import utils.validation.Validation;

public class ValidateInput {
    
    public Integer isNumberGreaterThanZero(final String parameter){
        try {
            final Integer number = Integer.parseInt(parameter);
            if (number>0) 
                return number;
            return null;
        } catch (Exception e) {
            return null;
        }
    }
    public Integer isValidCodeStudent(String codeStudent) {
	return Validation.isValidCode(codeStudent, null);
    }
    public Integer isValidCodeGrade(String codeGrade) {
        return Validation.isValidCode(codeGrade, 6);
    }
    public Integer isValidCodeSection(String codeSection) {
        return Validation.isValidCode(codeSection, 7);
    }
    public String isValidDNI(final String dni) {
        try {
            if (Validation.regexIsMatched(RegexPatternsValidation.DNI, dni)) {
                return dni;
            }
            return null ;
        } catch (Exception e) {
            return null;
        }
    }
    public String isValidPhone(final String phone) {
        try {
            return phone ;
        } catch (Exception e) {
            return null;
        }
    }
    public Date isValidDate(final String date) {
        try {
            Integer date1 = Integer.parseInt(date);
            Long i = new Long(date1); 
            Date d = new Date(i);
            return d ;
        } catch (Exception e) {
            return null;
        }
    }
    
    // Validación del grado para GradeToEnrollment
    public boolean isGradeValid(final GradeDTO newGrade){
        int grade = newGrade.getCode();
        return grade < 6;
    }
}
