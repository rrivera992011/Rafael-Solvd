package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Recipe;

public interface IRecipeDAO extends IBaseDAO<Recipe>{
    Recipe getRecipeFromRecipeSize(double recipeSize);
}
