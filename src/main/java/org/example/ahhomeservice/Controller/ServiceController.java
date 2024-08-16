package org.example.ahhomeservice.Controller;


import org.example.ahhomeservice.Model.AllServices;
import org.example.ahhomeservice.Model.SubCategory;
import org.example.ahhomeservice.Service.AllServiceService;
import org.example.ahhomeservice.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class ServiceController {

    @Autowired
    private AllServiceService allServiceService;

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/admin/services")
    public String services(Model model){
        List<AllServices> allServices = allServiceService.getallservice();
        List<SubCategory> subCategories = subCategoryService.getallsubcategories();
        model.addAttribute("subcategories", subCategories);
        model.addAttribute("services", allServices);
        return "admin/services";
    }

    @PostMapping("/admin/service/add-service")
    public String saveservice(AllServices allServices,@RequestParam("subcategory_id") Long subcategory_id, MultipartFile file, RedirectAttributes redirectAttributes){
        SubCategory subCategories = subCategoryService.findbyid(subcategory_id);
        allServices.setSubCategory(subCategories);

        allServiceService.saveservice(allServices, file);
        redirectAttributes.addFlashAttribute("successMessage", "Service Successfully Saved");

        return "redirect:/admin/services";

    }

    @PostMapping("/admin/services/delete")
    public String deleteservice(@RequestParam("id") Long id, RedirectAttributes redirectAttributes){
        allServiceService.deleteservice(id);
        redirectAttributes.addFlashAttribute("successMessage", "Service Deleted");
        return "redirect:/admin/services";
    }



}
