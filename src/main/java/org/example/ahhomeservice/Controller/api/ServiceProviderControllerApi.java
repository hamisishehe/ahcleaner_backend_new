package org.example.ahhomeservice.Controller.api;


import org.example.ahhomeservice.Model.ServiceProvider;
import org.example.ahhomeservice.Service.ServiceProviderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ServiceProviderControllerApi {

    @Autowired
    private ServiceProviderService serviceProviderService;


    @GetMapping("/api/serviceproviders")
    public List<ServiceProvider> getall(){
        return serviceProviderService.getall();
    }

    @GetMapping("/api/serviceproviders/{id}")
    public ResponseEntity<ServiceProvider> getbyid(@PathVariable Long id){
        Optional<ServiceProvider> serviceProvider = serviceProviderService.getbyid(id);

        if (serviceProvider.isPresent()){
            return ResponseEntity.ok(serviceProvider.get());
        }
        else {
            return ResponseEntity.notFound().build();
        }

    }


}
