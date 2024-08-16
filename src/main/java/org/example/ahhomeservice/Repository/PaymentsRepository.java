package org.example.ahhomeservice.Repository;

import org.example.ahhomeservice.Model.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentsRepository extends JpaRepository<Payment,Long> {
}
