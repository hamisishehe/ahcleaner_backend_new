package org.example.ahhomeservice.Repository;

import org.example.ahhomeservice.Model.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SubCategoryRepository extends JpaRepository<SubCategory , Long> {


    List<SubCategory> findByCategoryId(Long category_id);
}
