package com.example.recipe.controller;

import com.example.recipe.Repository.InstructionsRepo;
import com.example.recipe.Repository.RecipeRepo;
import com.example.recipe.Util.Validation;
import com.example.recipe.model.Cook;
import com.example.recipe.model.Recipe;
import com.example.recipe.service.CookService;
import jakarta.annotation.Nullable;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/cook")
public class CookController {
    @Autowired
    CookService cookService;

    @PostMapping(value = "/addCook")
    public ResponseEntity<String> addCook(@RequestBody String cook){
        JSONObject jsonObject=new JSONObject(cook);
        List<String> validationList= validateData(jsonObject);
        if(validationList.isEmpty()){
            Cook cook1=setCook(jsonObject);
            int cookId=cookService.saveCook(cook1);
            return new ResponseEntity<>("cook saved-"+cookId, HttpStatus.CREATED);
        }else{
            return new ResponseEntity<>("enter required parameters"+validationList.toString(), HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping(value = "/getAll")
    public List<Cook> getAll(){
        return cookService.getAll();
    }
    @GetMapping(value = "/getById/{cookId}")
    public List<Cook> getById(@Nullable @RequestParam String cookId) {
      return cookService.getCookById(String.valueOf(cookId));
    }
    @DeleteMapping(value = "/delete/{cookId}")
    public ResponseEntity<String> deleteCook(@PathVariable String cookId){
        cookService.deleteCook(cookId);
        return new ResponseEntity<>("Cook deleted-"+cookId, HttpStatus.OK);
    }
    @PutMapping(value = "update/{cookId}")
    public ResponseEntity<String> updateCook(@RequestBody String cook, @PathVariable int cookId){
        cookService.updateCook(cook, cookId);
        return new ResponseEntity<>("cook updated", HttpStatus.OK);
    }

    private Cook setCook(JSONObject jsonObject) {

        Cook cook=new Cook();
        cook.setCookName(jsonObject.getString("cookName"));
        cook.setEmail(jsonObject.getString("email"));
        cook.setPhoneNumber(jsonObject.getString("phoneNumber"));
        cook.setCookSpeciality(jsonObject.getString("cookSpeciality"));
        return cook;
    }

    private List<String> validateData(JSONObject jsonObject) {
        List<String> errorList=new ArrayList<>();
        if(!jsonObject.has("cookName")){
            errorList.add("cookName");
        }
        if(!jsonObject.has("cookSpeciality")){
            errorList.add("cookSpeciality");
        }
        if(!jsonObject.has("email")){
            errorList.add("email");
        }else{
            String email=jsonObject.getString("email");
            boolean ans= Validation.isValidEmail(email);
            if(ans==false){
                errorList.add("Enter a valid email address");
            }
        }
        if(!jsonObject.has("phoneNumber")){
            errorList.add("phoneNumber");
        }else{
            String number=jsonObject.getString("phoneNumber");
            boolean ans=Validation.isValidPhoneNumber(number);
            if(ans==false){
                errorList.add("Enter a valid Phone Number");
            }
        }
        return errorList;
    }
}
