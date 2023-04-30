package Student;

import Student.Student;
import Student.StudentRepository;
import Student.StudentService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImplement implements StudentService {

    private StudentRepository studentRepository;
    
    public StudentServiceImplement(StudentRepository studentRepository) {
        super();
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student saveStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Student updateStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public void deleteStudentById(Long id) {
        studentRepository.deleteById(id);
    }

   
    
}

