package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.Prescription;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class PrescriptionDAO implements IPrescriptionDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void updateEntity(Prescription prescription) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE prescription SET rx_number = (?), price_of_prescription = (?), " +
                "amount_of_medicine = (?), date_filled = (?), customer_id = (?), inventory_id = (?), recipe_id = (?) " +
                "WHERE prescription_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, prescription.getRxNumber());
            ps.setDouble(2, prescription.getPriceOfPrescription());
            ps.setInt(3, prescription.getAmountOfMedicine());
            ps.setDate(4, (Date) prescription.getDateFilled());
            ps.setInt(5, prescription.getCustomerId());
            ps.setInt(6, prescription.getInventoryId());
            ps.setInt(7, prescription.getRecipeId());
            ps.setInt(8, prescription.getPrescriptionId());
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
    public Prescription createEntity(Prescription prescription) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO prescription (prescription_id, rx_number, price_of_prescription, " +
                "amount_of_medicine, date_filled, customer_id, inventory_id, recipe_id) VALUES((?), (?), " +
                "(?), (?), (?), (?), (?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, prescription.getPrescriptionId());
            ps.setString(2, prescription.getRxNumber());
            ps.setDouble(3, prescription.getPriceOfPrescription());
            ps.setInt(4, prescription.getAmountOfMedicine());
            ps.setDate(5, (Date) prescription.getDateFilled());
            ps.setInt(6, prescription.getCustomerId());
            ps.setInt(7, prescription.getInventoryId());
            ps.setInt(8, prescription.getRecipeId());
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
        return prescription;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM prescription WHERE prescription_id = (?)";
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
    public List<Prescription> getAll() {
        Connection connection = connectionPool.getConnection();
        List<Prescription> resultList = new ArrayList<>();
        String query = "SELECT * FROM prescription";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while (rs.next()){
                    Prescription prescription = new Prescription();
                    prescription.setPrescriptionId(rs.getInt("prescription_id"));
                    prescription.setRxNumber(rs.getString("rx_number"));
                    prescription.setPriceOfPrescription(rs.getDouble("price_of_prescription"));
                    prescription.setAmountOfMedicine(rs.getInt("amount_of_medicine"));
                    prescription.setDateFilled(rs.getDate("date_filled"));
                    prescription.setCustomerId(rs.getInt("customer_id"));
                    prescription.setInventoryId(rs.getInt("inventory_id"));
                    prescription.setRecipeId(rs.getInt("recipe_id"));
                    resultList.add(prescription);
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
        return resultList;
    }

    @Override
    public Prescription getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        Prescription prescription = new Prescription();
        String query = "SELECT * FROM prescription WHERE prescription_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    prescription.setPrescriptionId(rs.getInt("prescription_id"));
                    prescription.setRxNumber(rs.getString("rx_number"));
                    prescription.setPriceOfPrescription(rs.getDouble("price_of_prescription"));
                    prescription.setAmountOfMedicine(rs.getInt("amount_of_medicine"));
                    prescription.setDateFilled(rs.getDate("date_filled"));
                    prescription.setCustomerId(rs.getInt("customer_id"));
                    prescription.setInventoryId(rs.getInt("inventory_id"));
                    prescription.setRecipeId(rs.getInt("recipe_id"));
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
        return prescription;
    }
}
