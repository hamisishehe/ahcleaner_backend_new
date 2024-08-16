package org.example.ahhomeservice.Controller;


import org.example.ahhomeservice.Model.ServiceProvider;
import org.example.ahhomeservice.Service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ServiceProviderController {

    @Autowired
    private ServiceProviderService serviceProviderService;


    @GetMapping("/admin/service-provider")
    public String service_provider(Model model){
        List<ServiceProvider> providers = serviceProviderService.getall();
        model.addAttribute("providers", providers);
        return "admin/service-provider";
    }

    @PostMapping("/admin/service-provider/add-provider")
    public String addnewprovider(ServiceProvider serviceProvider, RedirectAttributes redirectAttributes){
        serviceProviderService.save(serviceProvider);
        redirectAttributes.addFlashAttribute("successMessage", "New Account Created");

        return "redirect:/admin/service-provider";
    }
}
