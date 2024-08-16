package org.example.ahhomeservice.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "service_provider")
public class ServiceProvider {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private int phonenumber;

    private String email;

    private double rating;

    @Enumerated(EnumType.STRING)
    private Status status;




   public enum Status{
       ONLINE,
       OFFLINE
   }

    @OneToMany(mappedBy = "serviceProvider", cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Booking> bookings;


}
