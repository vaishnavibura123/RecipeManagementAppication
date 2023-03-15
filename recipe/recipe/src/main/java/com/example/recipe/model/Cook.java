package com.example.recipe.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tbl_cook")
public class Cook {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cook_id")
    private int cookId;
    @Column(name = "cook_name")
    private String cookName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    @Column(name = "cook_speciality")
    private String cookSpeciality;

}
