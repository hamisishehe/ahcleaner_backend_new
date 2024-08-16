package org.example.ahhomeservice.Controller;

import jakarta.validation.Valid;
import org.example.ahhomeservice.Model.Category;
import org.example.ahhomeservice.Repository.CategoryRepository;
import org.example.ahhomeservice.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.util.List;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @Autowired
    private CategoryRepository categoryRepository;


    @GetMapping("/admin/categories")
    public String categories(Model model) {
        List<Category> categories = categoryService.allcategories();
        model.addAttribute("categories", categories);
        return "admin/categories";
    }



    @PostMapping("/admin/categories/add-category")
    public String addcategory(@Valid Category category, BindingResult result, @RequestParam("file") MultipartFile file, Model model) {
        if (result.hasErrors()) {
            return "admin/categories";
        }
        categoryService.saveCategory(category, file);
        model.addAttribute("successMessage", "Category added successfully!");


        return "redirect:/admin/categories";
    }

    @GetMapping("/admin/edit-category/{id}")
    public String editcategory(@PathVariable("id") Long id, Model model){
        Category category = categoryService.findbyid(id);
        model.addAttribute("category", category);
        return "admin/edit-category";

    }

    @PostMapping("/admin/categories/delete")
    public String deletecategory(@RequestParam("id") Long id, RedirectAttributes redirectAttributes){

        try {
            categoryService.deleteCategory(id);
            redirectAttributes.addFlashAttribute("successMessage", "Category Deleted");
            return "redirect:/admin/categories";
        }
        catch (Exception e){
            redirectAttributes.addFlashAttribute("errorMessage", "Can Not Delete this category");
            return "redirect:/admin/categories";
        }

    }

    @PostMapping("/admin/categories/update")
    public String updateProduct(@RequestParam("id") Long id, @RequestParam("cat_name") String cat_name, @RequestParam("cat_description") String cat_description, RedirectAttributes redirectAttributes){

        Category category = categoryService.findbyid(id);

        category.setCat_name(cat_name);
        category.setCat_description(cat_description);

        categoryService.updatecategory(category);

        redirectAttributes.addFlashAttribute("successMessage", "Category Updated");
        return "redirect:/admin/categories";
    }






}
