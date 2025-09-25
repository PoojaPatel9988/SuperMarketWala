package com.example.seventh_project_super_market_wala.repo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.seventh_project_super_market_wala.model.Category;


@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {
	//future space

}
