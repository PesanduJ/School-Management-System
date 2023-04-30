/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Student;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 *
 * @author pesan
 */
public class PasswordEncoder {
    
    
    public static void main(String[] args){
        
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String rawPassword = "nam2020";
        String encodedPassword = encoder.encode(rawPassword);
        
        System.out.println(encodedPassword);
    }
}
