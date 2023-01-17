package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.Inventory;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.util.*;

public class InventoryDAO implements IInventoryDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void updateEntity(Inventory inventory) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO inventory (inventory_id, medicine_name, amount_left, amount_taken, category_id," +
                " price_of_medicine) VALUES((?), (?), (?), (?), (?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, inventory.getInventoryId());
            ps.setString(2, inventory.getMedicineName());
            ps.setInt(3, inventory.getAmountLeft());
            ps.setInt(4, inventory.getAmountTaken());
            ps.setInt(5, inventory.getCategoryId());
            ps.setDouble(6, inventory.getPriceOfMedicine());
            ps.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if(connection != null){
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
    }

    @Override
    public Inventory createEntity(Inventory inventory) {
        return null;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM inventory WHERE id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if(connection != null){
                try {
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
    }

    @Override
    public List<Inventory> getAll() {
        Connection connection = connectionPool.getConnection();
        List<Inventory> resultList = new ArrayList<>();
        String query = "SELECT * FROM inventory";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                Inventory inventory = new Inventory();
                inventory.setInventoryId(rs.getInt("inventory_id"));
                inventory.setMedicineName(rs.getString("medicine_name"));
                inventory.setAmountLeft(rs.getInt("amount_left"));
                inventory.setAmountTaken(rs.getInt("amount_taken"));
                inventory.setCategoryId(rs.getInt("category_id"));
                inventory.setPriceOfMedicine(rs.getDouble("price_of_medicine"));
                resultList.add(inventory);
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if(connection != null){
                try{
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return resultList;
    }

    @Override
    public Inventory getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Inventory inventory = new Inventory();
        String query = "SELECT * FROM inventory WHERE id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    inventory.setInventoryId(rs.getInt("inventory_id"));
                    inventory.setMedicineName(rs.getString("medicine_name"));
                    inventory.setAmountLeft(rs.getInt("amount_left"));
                    inventory.setAmountTaken(rs.getInt("amount_taken"));
                    inventory.setCategoryId(rs.getInt("category_id"));
                    inventory.setPriceOfMedicine(rs.getDouble("price_of_medicine"));
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e);
        } finally {
            if(connection != null){
                try{
                    connectionPool.releaseConnection(connection);
                } catch (SQLException e) {
                    LOGGER.error(e);
                }
            }
        }
        return inventory;
    }
}