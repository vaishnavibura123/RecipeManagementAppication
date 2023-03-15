package com.example.recipe.service;

import com.example.recipe.Repository.RecipeRepo;
import com.example.recipe.model.Cook;
import com.example.recipe.model.Instructions;
import com.example.recipe.model.Recipe;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RecipeService {
    @Autowired
    RecipeRepo recipeRepo;
    public int saveRecipe(Recipe recipe1) {
        Recipe recipe=recipeRepo.save(recipe1);
        return recipe.getRecipeId();
    }

    public List<Recipe> getAll() {
        List<Recipe> recipe=recipeRepo.findAll();
        return recipe;
    }

    public List<Recipe> getById(String recipeId) {
        List<Recipe> recipe;
        if(null!= recipeId){
            recipe=new ArrayList<>();
            recipe.add(recipeRepo.findById(Integer.valueOf(recipeId)).get());
        }else{
            recipe=recipeRepo.findAll();
        }
        return recipe;
    }

    public void deleteRecipe(String recipeId) {
        recipeRepo.deleteById(Integer.valueOf(recipeId));
    }

    public void updateRecipe(String recipe, int recipeId) {
        JSONObject json=new JSONObject(recipe);
        Recipe recipe1=recipeRepo.findById(recipeId).get();
        recipe1.setRecipeName(json.getString("recipeName"));
        recipe1.setIngredients(json.getString("ingredients"));

        recipeRepo.save(recipe1);
    }
}
