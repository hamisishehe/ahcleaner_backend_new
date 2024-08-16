package org.example.ahhomeservice.Controller;


import org.example.ahhomeservice.Model.User;
import org.example.ahhomeservice.Service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @GetMapping("/admin/users")
    public String homepage (Model model){
        List<User> users = userService.getAllUsers();
        model.addAttribute("users", users);
        return "admin/users";
    }

    @PostMapping("/admin/users/add-user")
    public  String adduser(User user, RedirectAttributes redirectAttributes, @RequestParam("email") String email, @RequestParam("username") String username, @RequestParam("phonenumber") int phonenumber, @RequestParam("role") String role){

        userService.registrationfromadmin(user,email,role,username,phonenumber);

        redirectAttributes.addFlashAttribute("SucccessMessage", "New User Created");
        return "redirect:/admin/users";
    }
}
