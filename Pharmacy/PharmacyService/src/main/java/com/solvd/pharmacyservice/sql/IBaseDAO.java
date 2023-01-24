package com.solvd.pharmacyservice.sql;

import java.util.List;

public interface IBaseDAO<Entity>{
    Entity getEntityById(int id);
    void updateEntity(Entity entity);
    Entity createEntity(Entity entity);
    void removeEntity(int id);
    List<Entity> getAll();
}
