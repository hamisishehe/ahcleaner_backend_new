package org.example.ahhomeservice.Service;


import org.example.ahhomeservice.Model.ServiceProvider;
import org.example.ahhomeservice.Repository.ServiceProviderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceProviderService {

    @Autowired
    private ServiceProviderRepository serviceProviderRepository;


    public List<ServiceProvider> getall(){
        return serviceProviderRepository.findAll();
    }

    public Long countall(){
        Long counts = serviceProviderRepository.count();
        return counts;
    }

    public ServiceProvider save(ServiceProvider serviceProvider){
        serviceProvider.setStatus(ServiceProvider.Status.ONLINE);
        serviceProvider.setRating(4.5);
        return serviceProviderRepository.save(serviceProvider);
    }

    public Optional<ServiceProvider> getbyid(Long id){
        return serviceProviderRepository.findById(id);
    }


}
