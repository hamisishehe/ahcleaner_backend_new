package org.example.ahhomeservice.Controller;


import jakarta.validation.Valid;
import org.example.ahhomeservice.Model.Category;
import org.example.ahhomeservice.Model.SubCategory;
import org.example.ahhomeservice.Repository.SubCategoryRepository;
import org.example.ahhomeservice.Service.CategoryService;
import org.example.ahhomeservice.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class SubCategoryController {

  @Autowired
  private  SubCategoryService  subCategoryService;

  @Autowired
  private CategoryService categoryService;


  @GetMapping("/admin/subcategories")
    public String subcategory(Model model){
      List<SubCategory> subCategories = subCategoryService.getallsubcategories();
      List<Category> categories = categoryService.allcategories();
      model.addAttribute("subcategories", subCategories);
      model.addAttribute("categories", categories);
      return "/admin/subcategories";

  }



  @PostMapping("/admin/subcategories/add-subcategory")
  public String addcategory(@Valid SubCategory subCategory,   @RequestParam("category_id") Long categoryId,  BindingResult result, @RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
    if (result.hasErrors()) {
      return "redirect:/admin/subcategories";
    }

    Category category = categoryService.findbyid(categoryId);
    subCategory.setCategory(category);
    subCategoryService.saveSubCategory(subCategory, file);
    redirectAttributes.addFlashAttribute("successMessage", "Category added successfully!");
    return "redirect:/admin/subcategories";
  }


  @PostMapping("/admin/subcategories/delete")
  public String deletesubcategory(@RequestParam("id") Long id, RedirectAttributes redirectAttributes){

    subCategoryService.deletesubcayegory(id);
    redirectAttributes.addFlashAttribute("SuccessMessage", "Sub Category Deleted");
    return "redirect:/admin/subcategories";
  }

}
