package com.gmail.yatchenko.serhii.cookbook.util;

import com.gmail.yatchenko.serhii.cookbook.dto.RecipeDto;
import com.gmail.yatchenko.serhii.cookbook.model.Recipe;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class RecipeDtoConverter {


    public Recipe getRecipeFromDto(RecipeDto recipeDto) {
        Recipe recipe = Recipe
                .builder()
                .name(recipeDto.getName())
                .date(recipeDto.getDate())
                .description(recipeDto.getDescription())
                .build();
        if (recipeDto.getRecipes().isEmpty()) {
            recipe.setRecipes(new ArrayList<Recipe>());
        } else {
            recipe
                    .setRecipes(
                            recipeDto
                                    .getRecipes()
                                    .stream()
                                    .map(this::getRecipeFromDto)
                                    .sorted(new CompareRecipe())
                                    .collect(Collectors.toList()));
        }
        return recipe;
    }

    public RecipeDto getDtoFromRecipe(Recipe recipe) {
        RecipeDto recipeDto = RecipeDto
                .builder()
                .name(recipe.getName())
                .date(recipe.getDate())
                .description(recipe.getDescription())
                .build();
        if (recipe.getRecipes().isEmpty()) {
            recipeDto.setRecipes(new ArrayList<RecipeDto>());
        } else {
            recipeDto
                    .setRecipes(
                            recipe.getRecipes()
                                    .stream()
                                    .map(this::getDtoFromRecipe)
                                    .sorted(new CompareRecipe())
                                    .collect(Collectors.toList()));
        }
        return recipeDto;
    }

}
