package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.PaymentType;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;

import java.sql.*;
import java.util.*;

public class PaymentTypeDAO implements IPaymentTypeDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void updateEntity(PaymentType paymentType) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE payment_type SET payment_type_name = (?) WHERE payment_type_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, paymentType.getPaymentTypeName());
            ps.setInt(2, paymentType.getPaymentTypeId());
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
    public PaymentType createEntity(PaymentType paymentType) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO payment_type (payment_type_id, payment_type_name) VALUES((?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, paymentType.getPaymentTypeId());
            ps.setString(2, paymentType.getPaymentTypeName());
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
        return paymentType;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM payment_type WHERE payment_type_id = (?)";
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
    public List<PaymentType> getAll() {
        Connection connection = connectionPool.getConnection();
        List<PaymentType> resultList = new ArrayList<>();
        String query = "SELECT * FROM payment_type";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while (rs.next()) {
                    PaymentType paymentType = new PaymentType();
                    paymentType.setPaymentTypeId(rs.getInt("payment_type_id"));
                    paymentType.setPaymentTypeName(rs.getString("payment_type_name"));
                    resultList.add(paymentType);
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
    public PaymentType getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        PaymentType paymentType = new PaymentType();
        String query = "SELECT * FROM payment_type WHERE payment_type_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    paymentType.setPaymentTypeId(rs.getInt("payment_type_id"));
                    paymentType.setPaymentTypeName(rs.getString("payment_type_name"));
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
        return paymentType;
    }

    @Override
    public PaymentType getPaymentTypeByName(String paymentTypeName) {
        Connection connection = connectionPool.getConnection();
        PaymentType paymentType = new PaymentType();
        String query = "SELECT * FROM payment_type WHERE payment_type_name = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, paymentTypeName);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    paymentType.setPaymentTypeId(rs.getInt("payment_type_id"));
                    paymentType.setPaymentTypeName(rs.getString("payment_type_name"));
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
        return paymentType;
    }
}
