package org.example.ahhomeservice.Controller.api;


import org.example.ahhomeservice.Model.Category;
import org.example.ahhomeservice.Service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class CategoryControllerApi {

    @Autowired
    private CategoryService categoryService;


    @GetMapping("/api/categories")
    public List<Category> getcategory(){
        return  categoryService.allcategories();
    }


}
