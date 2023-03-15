package com.example.recipe.service;

import com.example.recipe.Repository.InstructionsRepo;
import com.example.recipe.model.Cook;
import com.example.recipe.model.Instructions;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class InstructionService {
    @Autowired
    InstructionsRepo repo;
    public int saveInstructions(Instructions inst) {
        Instructions instruction=repo.save(inst);
        return instruction.getInstructionId();
    }

    public List<Instructions> getAll() {
        List<Instructions> instructions=repo.findAll();
        return instructions;

    }

    public List<Instructions> getById(String instructionId) {
        List<Instructions> instructions;
        if(null!= instructionId){
            instructions=new ArrayList<>();
            instructions.add(repo.findById(Integer.valueOf(instructionId)).get());
        }else{
            instructions=repo.findAll();
        }
        return instructions;
    }

    public void deleteInst(String instructionsId) {
        repo.deleteById(Integer.valueOf(instructionsId));
    }


    public void updateCook(String instructions, int instructionId) {
        JSONObject json=new JSONObject();
        Instructions inst=repo.findById(instructionId).get();
        inst.setDescription(json.getString("description"));
        repo.save(inst);

    }
}
