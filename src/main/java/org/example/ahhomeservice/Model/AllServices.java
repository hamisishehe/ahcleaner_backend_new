package org.example.ahhomeservice.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Set;

@Entity
@Data
@Table(name = "Services")
public class AllServices {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String service_name;

    @Column(nullable = false)
    private int service_price;

    @Column(nullable = false)
    private String service_image;

    @Column(nullable = true)
    private String description;



    @ManyToOne
    @JoinColumn(name = "subcategory_id")
    private SubCategory subCategory;
    


    @OneToMany(mappedBy = "allServices",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BookingServiceModel> bookingServiceModels;

    public AllServices(Long serviceId, Object o) {
    }

    public AllServices() {

    }
}
