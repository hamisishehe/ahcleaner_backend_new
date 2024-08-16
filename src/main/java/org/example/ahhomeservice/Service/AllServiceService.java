package org.example.ahhomeservice.Service;


import org.example.ahhomeservice.Model.AllServices;
import org.example.ahhomeservice.Model.Category;
import org.example.ahhomeservice.Model.SubCategory;
import org.example.ahhomeservice.Repository.AllServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

@Service
public class AllServiceService {

    private final Path rootLocation = Paths.get("src/main/resources/static/uploads");


    @Autowired
    private AllServiceRepository allServiceRepository;

    public List<AllServices> getallservice(){
        return allServiceRepository.findAll();
    }

    public Long countall(){
        Long count = allServiceRepository.count();
        return count;
    }

    public AllServices getByid(Long id){
        Optional<AllServices> allServices = allServiceRepository.findById(id);
        return  allServices.orElse(null);
    }

    public AllServices saveservice(AllServices allServices, MultipartFile file) {
        try {
            if (!file.isEmpty()) {
                Path destinationFile = this.rootLocation.resolve(
                                Paths.get(file.getOriginalFilename()))
                        .normalize().toAbsolutePath();

                file.transferTo(destinationFile);
                allServices.setService_image("/uploads/" + file.getOriginalFilename());
            }

            return allServiceRepository.save(allServices);
        } catch (IOException e) {
            throw new RuntimeException("Failed to store file", e);
        }
    }

    public void deleteservice(Long id){
        allServiceRepository.deleteById(id);
    }

    public List<AllServices> getservicebysubcategory(Long subcategory_id){
        return allServiceRepository.findBySubCategoryId(subcategory_id);
    }


}
