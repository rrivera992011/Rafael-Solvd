package com.solvd.pharmacyservice.models;

import javax.xml.bind.annotation.*;

@XmlRootElement(name = "category")
@XmlType(propOrder = {"categoryId", "categoryName"})
public class Category {
    private int categoryId;
    private String categoryName;

    public Category(int categoryId, String categoryName) {
        this.categoryId = categoryId;
        this.categoryName = categoryName;
    }

    public Category() {
    }

    public int getCategoryId() {
        return categoryId;
    }

    @XmlAttribute(name = "id")
    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getCategoryName() {
        return categoryName;
    }

    @XmlElement(name = "categoryName")
    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public String toString() {
        return "\nCategory ID = " + categoryId +
                ", Category Name = '" + categoryName + '\'';
    }
}
