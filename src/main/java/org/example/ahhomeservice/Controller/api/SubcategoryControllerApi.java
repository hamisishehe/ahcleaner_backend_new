package org.example.ahhomeservice.Controller.api;


import org.example.ahhomeservice.Model.Category;
import org.example.ahhomeservice.Model.SubCategory;
import org.example.ahhomeservice.Service.CategoryService;
import org.example.ahhomeservice.Service.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubcategoryControllerApi {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private SubCategoryService subCategoryService;

    @GetMapping("/api/subcategories/{id}")
    public List<SubCategory> getsubcategories(@PathVariable Long id){
        return subCategoryService.getbycategoryid(id);
    }
}
