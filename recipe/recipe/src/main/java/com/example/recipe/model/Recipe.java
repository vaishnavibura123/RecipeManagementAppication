package com.example.recipe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_recipe")
public class Recipe {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "recipe_id")
    private int recipeId;
    @Column(name = "recipe_name")
    private String recipeName;
    @Column(name = "ingredients")
    private String ingredients;
    @ManyToOne
    @JoinColumn(name = "cook_id")
    private Cook cook;

}
