package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Recipe;

public interface IRecipeDAO extends IBaseDAO<Recipe>{
    Recipe getRecipeByMedicineName (String medicineName);
    void updateRecipeSize(Recipe recipe);
}
