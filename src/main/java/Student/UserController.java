
package Student;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
     
    @Autowired
    private UserRepository userRepository;
    
    @GetMapping("")
    public String viewLogingPage(){
        return "index";
    }
    
    @GetMapping("/registration")
    public String showRegisterPage(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }
    
    @PostMapping("/registration")
    public String saveUserDetails(User user){
        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
        String encodedPassword = encoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "index";
    }
    
    @GetMapping("/list_users")
    public String viewUserList(Model model){
        List<User> listUsers = userRepository.findAll();
        model.addAttribute("listUsers", listUsers);
        return "users";
    }
    
}
