package org.example.ahhomeservice.Service;

import org.example.ahhomeservice.Model.Category;
import org.example.ahhomeservice.Repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    private final Path rootLocation;

    @Autowired
    private CategoryRepository categoryRepository;

    @Value("${file.upload-dir}")
    private String uploadDir;

    public CategoryService() {
        this.rootLocation = Paths.get(uploadDir);
        try {
            Files.createDirectories(this.rootLocation);
        } catch (IOException e) {
            throw new RuntimeException("Could not create upload directory!", e);
        }
    }

    public Long countAll() {
        return categoryRepository.count();
    }

    public Category saveCategory(Category category, MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                Path destinationFile = this.rootLocation.resolve(
                                Paths.get(file.getOriginalFilename()))
                        .normalize().toAbsolutePath();

                file.transferTo(destinationFile);
                category.setCat_image("/uploads/" + file.getOriginalFilename());
            }

            return categoryRepository.save(category);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    public List<Category> allCategories() {
        return categoryRepository.findAll();
    }

    public void deleteCategory(long id) {
        categoryRepository.deleteById(id);
    }

    public Category findById(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        return category.orElse(null);
    }

    public void updateCategory(Category category) {
        categoryRepository.save(category);
    }
}
