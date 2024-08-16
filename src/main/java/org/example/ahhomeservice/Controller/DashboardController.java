package org.example.ahhomeservice.Controller;



import org.example.ahhomeservice.Model.AllServices;
import org.example.ahhomeservice.Model.Category;
import org.example.ahhomeservice.Model.SubCategory;
import org.example.ahhomeservice.Model.User;
import org.example.ahhomeservice.Service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Optional;

@Controller("admindashboard")
public class DashboardController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    @Autowired
    private UserServiceImpl userService;

    @Autowired
    private BookingService bookingService;

    @Autowired
    private AllServiceService allServiceService;

    @Autowired
    private ServiceProviderService serviceProviderService;

    @GetMapping("/admin/dashboard")

    public String dashboard(Model model){

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentuser = authentication.getName();

        Long categories = categoryService.countall();


        Long subCategories = subCategoryService.countall();
        Long users = userService.countall();
        Long allServices = allServiceService.countall();
        Long booking = bookingService.countall();
        Long serviceprovider = serviceProviderService.countall();


        model.addAttribute("categories", categories);
        model.addAttribute("subcategories", subCategories);
        model.addAttribute("allservices", allServices);
        model.addAttribute("booking", booking);
        model.addAttribute("users", users);
        model.addAttribute("serviceprovider", serviceprovider);
        model.addAttribute("currentuser",currentuser);
        return "admin/dashboard";
    }

}
