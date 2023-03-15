package com.example.recipe.service;

import com.example.recipe.Repository.CookRepo;
import com.example.recipe.model.Cook;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CookService {
    @Autowired
    CookRepo  cookRepo;

    public int saveCook(Cook cook1) {
       Cook cook= cookRepo.save(cook1);
       return cook.getCookId();
    }

    public List<Cook> getAll() {
        List<Cook> cooks=cookRepo.findAll();
        return cooks;
    }

    public void deleteCook(String cookId) {
       cookRepo.deleteById(Integer.valueOf(cookId));
    }

    public void updateCook(String cook, int cookId) {
        JSONObject json=new JSONObject(cook);
        Cook cook2=cookRepo.findById(cookId).get();
        cook2.setCookName(json.getString("cookName"));
        cook2.setCookSpeciality(json.getString("cookSpeciality"));
        cook2.setEmail(json.getString("email"));
        cook2.setPhoneNumber(json.getString("phoneNumber"));
        cookRepo.save(cook2);
    }


    public List<Cook> getCookById(String cookId) {
        List<Cook> cooks;
        if(null!= cookId){
            cooks=new ArrayList<>();
            cooks.add(cookRepo.findById(Integer.valueOf(cookId)).get());
        }else{
            cooks=cookRepo.findAll();
        }
        return cooks;
    }
}
