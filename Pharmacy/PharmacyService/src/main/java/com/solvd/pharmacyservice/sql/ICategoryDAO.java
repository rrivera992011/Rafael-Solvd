package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Category;

public interface ICategoryDAO extends IBaseDAO<Category> {
    Category getCategoryByName(String categoryName);
}
