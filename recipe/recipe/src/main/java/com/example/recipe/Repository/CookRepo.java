package com.example.recipe.Repository;

import com.example.recipe.model.Cook;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CookRepo extends JpaRepository<Cook, Integer> {
}
