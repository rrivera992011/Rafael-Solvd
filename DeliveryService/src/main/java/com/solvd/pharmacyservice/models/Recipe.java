package com.solvd.pharmacyservice.models;

public class Recipe {
    private int recipeId;
    private double recipeSize;

    public Recipe(int recipeId, double recipeSize) {
        this.recipeId = recipeId;
        this.recipeSize = recipeSize;
    }

    public Recipe() {
    }

    public int getRecipeId() {
        return this.recipeId;
    }

    public void setRecipeId(int recipeId) {
        this.recipeId = recipeId;
    }

    public double getRecipeSize() {
        return this.recipeSize;
    }

    public void setRecipeSize(double recipeSize) {
        this.recipeSize = recipeSize;
    }

    @Override
    public String toString() {
        return "\nRecipe ID = " + recipeId +
                ", Recipe Size = " + recipeSize;
    }
}
