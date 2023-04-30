package Student;


import Student.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StudentManagementSystemApplication implements CommandLineRunner{

    
    /*
       Group Memebers : COHDSE212F-035
                        COHDSE212F-041
                        COHDSE212F-040
                        COHDSE212F-003
    
    */
    
    
	public static void main(String[] args) {
		SpringApplication.run(StudentManagementSystemApplication.class, args);
	}

        @Autowired
        private StudentRepository studentRepository;
        
    @Override
    public void run(String... args) throws Exception {
        
       
        
    }

}
