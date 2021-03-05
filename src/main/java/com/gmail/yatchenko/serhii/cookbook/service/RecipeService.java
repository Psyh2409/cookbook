package com.gmail.yatchenko.serhii.cookbook.service;

import com.gmail.yatchenko.serhii.cookbook.dto.RecipeDto;
import com.gmail.yatchenko.serhii.cookbook.model.Recipe;
import com.gmail.yatchenko.serhii.cookbook.repository.RecipeRepository;
import com.gmail.yatchenko.serhii.cookbook.util.CompareRecipe;
import com.gmail.yatchenko.serhii.cookbook.util.RecipeDtoConverter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@NoArgsConstructor
@AllArgsConstructor
public class RecipeService {
    @Autowired
    private RecipeRepository repository;

    @Autowired
    private RecipeDtoConverter converter;

    public List<RecipeDto> findAll() {
        // V TODO use converter for sorting
        var recips = repository
                .findAll()
                .stream()
                .sorted(new CompareRecipe())
                .collect(Collectors.toList());
        List<RecipeDto> dtoRecipes = new ArrayList<>();
        for (Recipe r: recips) {
            dtoRecipes.add(converter.getDtoFromRecipe(r));
        }
        return dtoRecipes;
    }

    public void saveAll(List<RecipeDto> recipesDto) {
        List<Recipe> recipes = new ArrayList<>();
        for (RecipeDto rd: recipesDto) {
            recipes.add(converter.getRecipeFromDto(rd));
        }
        repository.saveAll(recipes);
    }

}
