package com.solvd.pharmacyservice.models;

public class Recipe {
    private int recipe_id;
    private double recipe_size;
    private String medicine_name;

    public int getRecipeId() {
        return this.recipe_id;
    }

    public void setRecipeId(int recipe_id) {
        this.recipe_id = recipe_id;
    }

    public double getRecipeSize() {
        return this.recipe_size;
    }

    public void setRecipeSize(double recipe_size) {
        this.recipe_size = recipe_size;
    }

    public String getMedicineName() {
        return this.medicine_name;
    }

    public void setMedicineName(String medicine_name) {
        this.medicine_name = medicine_name;
    }
}
