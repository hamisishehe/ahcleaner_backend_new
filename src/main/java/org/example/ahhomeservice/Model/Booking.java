package org.example.ahhomeservice.Model;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.Set;

@Entity
@Data
@Table(name = "Booking")
public class Booking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(nullable = false)
    private String location;

    @Column(nullable = false)
    private String workingDate;

    @Column(nullable = false)
    private String hoursspend;

    @Column(nullable = false)
    private double total_amount;

    @Column(nullable = true)
    private String instructions;

    @Enumerated(EnumType.STRING)
    private PaymentStatus paymentstatus;

    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt;

    @Column(nullable = false)
    private LocalDateTime updatedAt;

    public enum Status{
        PENDING,
        ONGOING,
        FINISHED
    }

    public enum PaymentStatus{
        PENDING,
        COMPLETED
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Booking booking = (Booking) o;
        return Objects.equals(id, booking.id) &&
                Objects.equals(user, booking.user) &&
                status == booking.status &&
                Objects.equals(location, booking.location) &&
                Objects.equals(workingDate, booking.workingDate) &&
                hoursspend == booking.hoursspend &&
                Double.compare(booking.total_amount, total_amount) == 0 &&
                Objects.equals(instructions, booking.instructions) &&
                paymentstatus == booking.paymentstatus &&
                Objects.equals(serviceProvider, booking.serviceProvider);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, status, location, workingDate, hoursspend, total_amount, instructions, paymentstatus, serviceProvider);
    }

    @ManyToOne
    @JoinColumn(name = "service_provider_id")
    private ServiceProvider serviceProvider;

    @OneToMany(mappedBy = "booking", fetch = FetchType.LAZY,cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<Payment> payments;


    @OneToMany(mappedBy = "booking",fetch = FetchType.LAZY, cascade = CascadeType.ALL, orphanRemoval = true)
    private Set<BookingServiceModel> bookingServiceModels;




}
