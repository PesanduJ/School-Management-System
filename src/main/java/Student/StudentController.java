package Student;

import Student.Student;
import Student.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class StudentController {
     
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        super();
        this.studentService = studentService;
    }
    
    //View all students
    @GetMapping("/students") 
    public String listStudents(Model model){
        model.addAttribute("students", studentService.getAllStudents());
        return "students";
    }
    
    
    //Add new student
    @GetMapping("/students/new")
    public String createStudentForm(Model model){
        Student student = new Student();
        model.addAttribute("student", student);
        return "create_student";
    } 
    
    @PostMapping("/students")
    public String saveStudent(@ModelAttribute("student") Student student){
        studentService.saveStudent(student);
        return "redirect:/students";
    }
    
        
    //Update student details
    @GetMapping("/students/edit/{id}")
    public String editStudentForm(@PathVariable Long id,Model model){
        model.addAttribute("student", studentService.getStudentById(id));
        return "edit_student";
    }
    
    @PostMapping("/students/{id}")
    public String updateStudent(@PathVariable Long id, @ModelAttribute("student") Student student,Model model){
        
        //get student from database by id
        Student existingStudent = studentService.getStudentById(id);
        
        existingStudent.setId(id);
        existingStudent.setFirst_name(student.getFirst_name());
        existingStudent.setLast_name(student.getLast_name());
        existingStudent.setAge(student.getAge());
        existingStudent.setTelephone_no(student.getTelephone_no());
        existingStudent.setEmail(student.getEmail());
        
        //save updated student object
        studentService.updateStudent(existingStudent);
        return "redirect:/students";
    }
    
    
    //Delete student 
    @GetMapping("/students/{id}")
    public String deleteStudent(@PathVariable Long id){
        studentService.deleteStudentById(id);
        return "redirect:/students";
    }
}
