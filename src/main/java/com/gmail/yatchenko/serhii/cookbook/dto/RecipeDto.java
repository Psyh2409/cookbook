package com.gmail.yatchenko.serhii.cookbook.dto;

import com.gmail.yatchenko.serhii.cookbook.util.RecipeInterface;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RecipeDto implements RecipeInterface {

    private String name;
    private String description;
    private LocalDate date;
    private List<RecipeDto> recipes;

}