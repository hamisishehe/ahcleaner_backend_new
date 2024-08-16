package org.example.ahhomeservice.Controller;


import org.example.ahhomeservice.Model.Payment;
import org.example.ahhomeservice.Service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class PaymentsController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/admin/payments")
    public String payment(Model model){
        List<Payment> payments = paymentService.getall();
        model.addAttribute("payments", payments);
        return "admin/payments";
    }
}
