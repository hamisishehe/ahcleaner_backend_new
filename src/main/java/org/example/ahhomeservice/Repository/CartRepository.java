package org.example.ahhomeservice.Repository;

import org.example.ahhomeservice.Model.Cart;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Long> {
    List<Cart> findByUser_Id(Long id);
    Optional<Cart> findByUser_IdAndAllServices_Id(Long user_id, Long service_id);
}
