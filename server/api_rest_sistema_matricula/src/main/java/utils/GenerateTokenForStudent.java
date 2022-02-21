package utils;

import java.util.Arrays;
import java.util.Collections;


public class GenerateTokenForStudent {
    
    public String tokenForActivationAccountStudent(){
                
        String lettersMayus, letterMin, specialChar, number, newPassword ="";
        int  amountCharacter;
        
        lettersMayus = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";   
        letterMin = "abcdefghijklmnñopqrstuvwxyz";        
        specialChar = "+-*/=%&#!?^|<>()[]{}:;.;~|";
        number = "1234567890";
        amountCharacter=5;

        newPassword = random(newPassword, letterMin, amountCharacter);
        
        newPassword = random(newPassword, lettersMayus, amountCharacter);
        
        newPassword = random(newPassword, specialChar, amountCharacter);
        
        newPassword = random(newPassword, number, amountCharacter);
        
        System.out.println("contraseña en orden : " + newPassword);
        
        String arrayWord[] = newPassword.split("");
        Collections.shuffle(Arrays.asList(arrayWord));
        newPassword = "";
        for (int i = 0; arrayWord.length > i; i++) {
            newPassword = newPassword + arrayWord[i];
        }
        return newPassword;
        
    }
    private String random(String newPassword , String letters, int amount){
        String [] arrayLetter = letters.split("");
        int numberRandom = 0;
        for (int i = 0 ; i < amount ; i++) {
            numberRandom = (int)(Math.random()*(arrayLetter.length-1)+0);
            newPassword = newPassword + arrayLetter[numberRandom];
        }
        return newPassword;
    }
}
