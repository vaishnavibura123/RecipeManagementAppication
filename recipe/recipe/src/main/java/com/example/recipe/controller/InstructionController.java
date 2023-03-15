package com.example.recipe.controller;

import com.example.recipe.Repository.RecipeRepo;
import com.example.recipe.model.Cook;
import com.example.recipe.model.Instructions;
import com.example.recipe.service.InstructionService;
import org.aspectj.apache.bcel.generic.Instruction;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/instructions")
public class InstructionController {
    @Autowired
    InstructionService service;

    @PostMapping(value = "/addInstructions")
    public ResponseEntity<String> createInstructions(@RequestBody String instructions){
        JSONObject json=new JSONObject(instructions);
        Instructions instructions1=new Instructions();
        instructions1.setDescription(json.getString("description"));
        int instId=service.saveInstructions(instructions1);
        return new ResponseEntity<>("instructions saved"+instId, HttpStatus.CREATED);

    }
    @GetMapping(value = "/getAll")
    public List<Instructions> getAll(){
        return service.getAll();
    }
    @GetMapping(value = "/getById/{instructionsId}")
    public List<Instructions> getById(@RequestParam String instructionsId) {
        return service.getById(String.valueOf(instructionsId));
    }
    @DeleteMapping(value = "/delete/{instructionsId}")
    public ResponseEntity<String> deleteInst(@PathVariable String instructionsId){
        service.deleteInst(instructionsId);
        return new ResponseEntity<>("instructions deleted-"+instructionsId, HttpStatus.OK);
    }
    @PutMapping(value = "update/{cookId}")
    public ResponseEntity<String> updateCook(@RequestBody String instructions, @PathVariable int instructionId){
        service.updateCook(instructions, instructionId);
        return new ResponseEntity<>("instructions updated", HttpStatus.OK);
    }


}
