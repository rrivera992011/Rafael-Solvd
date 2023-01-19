package com.solvd.pharmacyservice.sql;

import com.solvd.pharmacyservice.models.Inventory;

public interface IInventoryDAO extends IBaseDAO<Inventory>{
    Inventory getInventoryByMedicineName(String medicineName);
    void updatePriceByMedicineName(Inventory inventory);
    void removeInventoryWithAmountLeft(int amountLeft);
    void updateAmountTakenAndAmountLeft(Inventory inventory);
}
