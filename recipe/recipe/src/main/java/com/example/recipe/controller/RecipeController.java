package com.example.recipe.controller;

import com.example.recipe.Repository.CookRepo;
import com.example.recipe.model.Cook;
import com.example.recipe.model.Recipe;
import com.example.recipe.service.RecipeService;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/recipe")
public class RecipeController {
    @Autowired
    RecipeService recipeService;
    @Autowired
    CookRepo cookRepo;
    @PostMapping(value = "/addRecipe")
    public ResponseEntity<String> createRecipe(@RequestBody String recipe){
      Recipe recipe1=setRecipe(recipe);
      int recipeId=recipeService.saveRecipe(recipe1);
      return new ResponseEntity<>("Recipe Saved-"+recipeId, HttpStatus.CREATED);
    }

    private Recipe setRecipe(String recipe) {
        JSONObject jsonObject=new JSONObject(recipe);
        Cook cook=null;
        int cookId=jsonObject.getInt("cookId");
        if(cookRepo.findById(cookId).isPresent()){
            cook=cookRepo.findById(cookId).get();

        }else {
            return null;
        }
        Recipe recipe1=new Recipe();
        recipe1.setCook(cook);
        recipe1.setRecipeName(jsonObject.getString("recipeName"));
        recipe1.setIngredients(jsonObject.getString("ingredients"));
        return recipe1;
    }


    @GetMapping(value = "/getAll")
    public List<Recipe> getAll(){
        return recipeService.getAll();
    }
    @GetMapping(value = "/getById/{recipeId}")
    public List<Recipe> getById(@RequestParam String recipeId) {
        return recipeService.getById(String.valueOf(recipeId));
    }
    @DeleteMapping(value = "/delete/{recipeId}")
    public ResponseEntity<String> deleteRecipe(@PathVariable String recipeId){
        recipeService.deleteRecipe(recipeId);
        return new ResponseEntity<>("Recipe deleted-"+recipeId, HttpStatus.OK);
    }
    @PutMapping(value = "update/{cookId}")
    public ResponseEntity<String> updateRecipe(@RequestBody String recipe, @PathVariable int recipeId){
        recipeService.updateRecipe(recipe, recipeId);
        return new ResponseEntity<>("Recipe updated", HttpStatus.OK);
    }
}
