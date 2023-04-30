package Student;

import Student.*;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "teachers")
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    
    @Column(name = "first_name" , nullable = false)
    private String first_name;
    
    @Column(name = "last_name" , nullable = false)
    private String last_name;
    
    @Column(name = "email" , nullable = false)
    private String email;

    @Column(name = "age" , nullable = false)
    private long age;
    
    @Column(name = "telephone_no" , nullable = false)
    private long telephone_no;
    
    
    
    public Teacher(){
        
    }

    public Teacher(long id, String first_name, String email, long age, long telephone_no) {
        this.id = id;
        this.first_name = first_name;
        this.age = age;
        this.telephone_no = telephone_no;
        this.email = email;
    }

    

    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public long getTelephone_no() {
        return telephone_no;
    }

    public void setTelephone_no(long telephone_no) {
        this.telephone_no = telephone_no;
    }
    
    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }
    
}
