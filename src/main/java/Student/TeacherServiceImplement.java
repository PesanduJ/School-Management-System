package Student;

import Student.Teacher;
import Student.TeacherRepository;
import Student.TeacherService;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TeacherServiceImplement implements TeacherService {

    private TeacherRepository teacherRepository;
    
    public TeacherServiceImplement(TeacherRepository teacherRepository) {
        super();
        this.teacherRepository = teacherRepository;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        return teacherRepository.findAll();
    }

    @Override
    public Teacher saveTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public Teacher getTeacherById(Long id) {
        return teacherRepository.findById(id).get();
    }

    @Override
    public Teacher updateTeacher(Teacher teacher) {
        return teacherRepository.save(teacher);
    }

    @Override
    public void deleteTeacherById(Long id) {
        teacherRepository.deleteById(id);
    }

   
    
}

