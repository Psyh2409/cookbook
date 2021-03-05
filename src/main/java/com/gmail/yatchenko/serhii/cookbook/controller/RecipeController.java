package com.gmail.yatchenko.serhii.cookbook.controller;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.gmail.yatchenko.serhii.cookbook.dto.RecipeDto;
import com.gmail.yatchenko.serhii.cookbook.service.RecipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecipeController {
    @Autowired
    private RecipeService service;

    @GetMapping("/recipes")
    public List<RecipeDto> getAllRecipes(){
        return service.findAll();
    }

    @PostMapping("/save/all")
    @JsonFormat(pattern = "yyyy-mm-dd")
    public void saveRecipes(@RequestBody List<RecipeDto> recipesDto){
        service.saveAll(recipesDto);
    }

    @PostMapping("/add/into")
    @JsonFormat(pattern = "yyyy-mm-dd")
    public void addInto(@RequestBody RecipeDto recipeDto, @RequestBody List<RecipeDto> recipesDto){
        //service.saveAll(recipesDto);
    }

    @PostMapping("/add/to")
    @JsonFormat(pattern = "yyyy-mm-dd")
    public void addTo(@RequestBody List<RecipeDto> recipesDto){
       // service.saveAll(recipesDto);
    }
}
