package Student;

import Student.Teacher;
import Student.TeacherService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;




@Controller
public class TeacherController {
     
    private TeacherService teacherService;

    public TeacherController(TeacherService teacherService) {
        super();
        this.teacherService = teacherService;
    }
    
    //View all teachers
    @GetMapping("/teachers") 
    public String listTeachers(Model model){
        model.addAttribute("teachers", teacherService.getAllTeachers());
        return "teachers";
    }
    
    
    //Add new teacher
    @GetMapping("/teachers/new")
    public String createTeacherForm(Model model){
        Teacher teacher = new Teacher();
        model.addAttribute("teacher", teacher);
        return "create_teacher";
    } 
    
    @PostMapping("/teachers")
    public String saveTeacher(@ModelAttribute("teacher") Teacher teacher){
        teacherService.saveTeacher(teacher);
        return "redirect:/teachers";
    }
    
        
    //Update teacher details
    @GetMapping("/teachers/edit/{id}")
    public String editTeacherForm(@PathVariable Long id,Model model){
        model.addAttribute("teacher", teacherService.getTeacherById(id));
        return "edit_teacher";
    }
    
    @PostMapping("/teachers/{id}")
    public String updateTeacher(@PathVariable Long id, @ModelAttribute("teacher") Teacher teacher,Model model){
        
        //get teacher from database by id
        Teacher existingTeacher = teacherService.getTeacherById(id);
        
        existingTeacher.setId(id);
        existingTeacher.setFirst_name(teacher.getFirst_name());
        existingTeacher.setLast_name(teacher.getLast_name());
        existingTeacher.setAge(teacher.getAge());
        existingTeacher.setTelephone_no(teacher.getTelephone_no());
        existingTeacher.setEmail(teacher.getEmail());
        
        //save updated student object
        teacherService.updateTeacher(existingTeacher);
        return "redirect:/teachers";
    }
    
    
    //Delete student 
    @GetMapping("/teachers/{id}")
    public String deleteTeacher(@PathVariable Long id){
        teacherService.deleteTeacherById(id);
        return "redirect:/teachers";
    }
}
