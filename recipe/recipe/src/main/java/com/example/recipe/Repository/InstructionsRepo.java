package com.example.recipe.Repository;

import com.example.recipe.model.Instructions;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstructionsRepo extends JpaRepository<Instructions, Integer> {
}
