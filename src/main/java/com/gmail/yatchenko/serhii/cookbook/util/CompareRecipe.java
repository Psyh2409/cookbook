package com.gmail.yatchenko.serhii.cookbook.util;

import java.util.Comparator;

public class CompareRecipe implements Comparator<RecipeInterface> {
    @Override
    public int compare(RecipeInterface o1, RecipeInterface o2) {
        return o1.getName().compareTo(o2.getName());
    }
}
