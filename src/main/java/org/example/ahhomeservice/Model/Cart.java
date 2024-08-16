package org.example.ahhomeservice.Model;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int quantity;

    private int total_price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    @ManyToOne
    @JoinColumn(name = "service_id")
    private AllServices allServices;

}
