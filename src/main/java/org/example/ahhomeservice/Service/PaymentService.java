package org.example.ahhomeservice.Service;


import org.example.ahhomeservice.Model.Payment;
import org.example.ahhomeservice.Repository.PaymentsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentsRepository paymentsRepository;


    public List<Payment> getall(){
        return paymentsRepository.findAll();
    }
}
