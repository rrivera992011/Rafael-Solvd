package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Inventory;

public interface IInventoryDAO extends IBaseDAO<Inventory>{
    Inventory getInventoryByMedicineName(String medicineName);
    void removeInventoryWithAmountLeft(int amountLeft);
}
