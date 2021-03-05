package com.gmail.yatchenko.serhii.cookbook.repository;

import com.gmail.yatchenko.serhii.cookbook.model.Recipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RecipeRepository extends JpaRepository<Recipe, Long> {
}
