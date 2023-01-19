package com.solvd.pharmacyservice.models;

public class Recipe {
    private int recipeId;
    private double recipeSize;
    private String medicineName;

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

    public String getMedicineName() {
        return this.medicineName;
    }

    public void setMedicineName(String medicineName) {
        this.medicineName = medicineName;
    }

    @Override
    public String toString() {
        return "\nRecipe ID = " + recipeId +
                ", Recipe Size = " + recipeSize +
                ", Medicine Name = '" + medicineName + '\'';
    }
}
