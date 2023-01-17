package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.Customer;
import com.solvd.pharmacyservice.sql.ConnectionPool;
import java.sql.*;
import java.util.*;
import com.solvd.pharmacyservice.sql.ICustomerDAO;
import org.apache.logging.log4j.*;


public class CustomerDAO implements ICustomerDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public Customer getEntityById(int id){
        Connection connection = connectionPool.getConnection();
        Customer customer = new Customer();
        String query = "SELECT * FROM customer WHERE id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    customer.setCustomerId(rs.getInt("customer_id"));
                    customer.setFirstName(rs.getString("first_name"));
                    customer.setLastName(rs.getString("last_name"));
                    customer.setPhoneNumber(rs.getString("phone_number"));
                    customer.setAge(rs.getInt("age"));
                    customer.setAddress(rs.getString("address"));
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
        return customer;
    }

    @Override
    public void updateEntity(Customer customer) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO customer (customer_id, first_name, last_name, phone_number, age, address)" +
                " VALUES((?), (?), (?), (?), (?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, customer.getCustomerId());
            ps.setString(2, customer.getFirstName());
            ps.setString(3, customer.getLastName());
            ps.setString(4, customer.getPhoneNumber());
            ps.setInt(5, customer.getAge());
            ps.setString(6, customer.getAddress());
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
    public Customer createEntity(Customer customer) {
        return null;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM customer WHERE id = (?)";
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
    public List<Customer> getAll() {
        Connection connection = connectionPool.getConnection();
        List<Customer> resultList = new ArrayList<>();
        String query = "SELECT * FROM customer";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                Customer customer = new Customer();
                customer.setCustomerId(rs.getInt("customer_id"));
                customer.setFirstName(rs.getString("first_name"));
                customer.setLastName(rs.getString("last_name"));
                customer.setPhoneNumber(rs.getString("phone_number"));
                customer.setAge(rs.getInt("age"));
                customer.setAddress(rs.getString("address"));
                resultList.add(customer);
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
}
