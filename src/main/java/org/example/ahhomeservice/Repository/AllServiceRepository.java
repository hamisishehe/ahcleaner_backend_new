package org.example.ahhomeservice.Repository;

import org.example.ahhomeservice.Model.AllServices;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AllServiceRepository extends JpaRepository<AllServices , Long > {


    List<AllServices> findBySubCategoryId(Long subcategoryId);
}
