package org.example.ahhomeservice.Service;


import org.example.ahhomeservice.Model.Category;
import org.example.ahhomeservice.Model.SubCategory;
import org.example.ahhomeservice.Repository.CategoryRepository;
import org.example.ahhomeservice.Repository.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class SubCategoryService {

    private final Path rootLocation = Paths.get("src/main/resources/static/uploads");

    @Autowired
    private SubCategoryRepository subCategoryRepository;

    @Autowired
    private CategoryRepository categoryRepository;


    public List<SubCategory> getallsubcategories(){
        return subCategoryRepository.findAll();
    }


    public SubCategory saveSubCategory(SubCategory subCategory, MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                Path destinationFile = this.rootLocation.resolve(
                                Paths.get(file.getOriginalFilename()))
                        .normalize().toAbsolutePath();

                file.transferTo(destinationFile);
                subCategory.setSubcat_image("/uploads/" + file.getOriginalFilename());
            }

            return subCategoryRepository.save(subCategory);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    public Long countall(){
        Long count = subCategoryRepository.count();
        return count;
    }


    public void deletesubcayegory(Long id){
         subCategoryRepository.deleteById(id);
    }

    public SubCategory findbyid(Long id){
        Optional<SubCategory> subCategory = subCategoryRepository.findById(id);
        return subCategory.orElse(null);
    }


    public List<SubCategory> getbycategoryid(Long category_id){
        List<SubCategory> subCategories = subCategoryRepository.findByCategoryId(category_id);
        return  subCategories;
    }



}
