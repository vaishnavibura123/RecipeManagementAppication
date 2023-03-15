package com.example.recipe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_instructions")
public class Instructions {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "inst_id")
    public int instructionId;
    @Column(name = "description")
    private String description;

}
