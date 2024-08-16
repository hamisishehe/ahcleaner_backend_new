package org.example.ahhomeservice.Model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;

@Entity
@Data
@Table(name = "BookingService")
public class BookingServiceModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "booking_id")
    private Booking booking;

    @ManyToOne
    @JoinColumn(name = "service_id")
    private AllServices allServices;

    @Column(nullable = false)
    private int quantity;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BookingServiceModel that = (BookingServiceModel) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(booking, that.booking) &&
                Objects.equals(allServices, that.allServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, booking, allServices);
    }
}
