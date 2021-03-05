package com.gmail.yatchenko.serhii.cookbook.model;

import com.gmail.yatchenko.serhii.cookbook.util.RecipeInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table
public class Recipe implements RecipeInterface {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column
    private String name;
    @Column
    private String description;
    @Column
    private LocalDate date;
    @OneToMany (cascade = CascadeType.ALL)
    private List<Recipe> recipes;
}

