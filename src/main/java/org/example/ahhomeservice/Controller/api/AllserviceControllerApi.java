package org.example.ahhomeservice.Controller.api;


import org.example.ahhomeservice.Model.AllServices;
import org.example.ahhomeservice.Service.AllServiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AllserviceControllerApi {

    @Autowired
    private AllServiceService allServiceService;

    @GetMapping("/api/service/{id}")
    private List<AllServices> getservice(@PathVariable Long id){
        return allServiceService.getservicebysubcategory(id);
    }

}
