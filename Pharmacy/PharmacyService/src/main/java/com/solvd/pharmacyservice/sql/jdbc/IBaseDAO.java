package com.solvd.pharmacyservice.sql.jdbc;

import java.util.List;

public interface IBaseDAO<Entity>{
    Entity getEntityById(long id);
    void updateEntity(Entity entity);
    Entity createEntity(Entity entity);
    void removeEntity(long id);
    List<Entity> getAll();
}
