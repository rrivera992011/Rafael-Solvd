package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.CustomerOrder;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.sql.Date;
import java.util.*;

public class CustomerOrderDAO implements ICustomerOrderDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void updateEntity(CustomerOrder customerOrder) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE customer_order SET order_total = (?), customer_id = (?), order_date = (?), " +
                "payment_type_id = (?), product_id = (?) WHERE customer_order_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setDouble(1, customerOrder.getOrderTotal());
            ps.setInt(2, customerOrder.getCustomerId());
            ps.setDate(3, (Date) customerOrder.getOrderDate());
            ps.setInt(4, customerOrder.getPaymentTypeId());
            ps.setInt(5, customerOrder.getProductId());
            ps.setInt(6, customerOrder.getCustomerOrderId());
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
    public CustomerOrder createEntity(CustomerOrder customerOrder) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO customer_order (customer_order_id, order_total, customer_id, order_date, " +
                "payment_type_id, product_id) VALUES((?), (?), (?), (?), (?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, customerOrder.getCustomerOrderId());
            ps.setDouble(2, customerOrder.getOrderTotal());
            ps.setInt(3, customerOrder.getCustomerId());
            ps.setDate(4, (Date) customerOrder.getOrderDate());
            ps.setInt(5, customerOrder.getPaymentTypeId());
            ps.setInt(6, customerOrder.getProductId());
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

        return customerOrder;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM customer_order WHERE customer_order_id = (?)";
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
    public List<CustomerOrder> getAll() {
        Connection connection = connectionPool.getConnection();
        List<CustomerOrder> resultList = new ArrayList<>();
        String query = "SELECT * FROM customer_order";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    CustomerOrder customerOrder = new CustomerOrder();
                    customerOrder.setCustomerOrderId(rs.getInt("customer_order_id"));
                    customerOrder.setOrderTotal(rs.getDouble("order_total"));
                    customerOrder.setCustomerId(rs.getInt("customer_id"));
                    customerOrder.setOrderDate(rs.getDate("order_date"));
                    customerOrder.setPaymentTypeId(rs.getInt("payment_type_id"));
                    customerOrder.setProductId(rs.getInt("product_id"));
                    resultList.add(customerOrder);
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
    public CustomerOrder getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        CustomerOrder customerOrder = new CustomerOrder();
        String query = "SELECT * FROM customer_order WHERE customer_order_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    customerOrder.setCustomerOrderId(rs.getInt("customer_order_id"));
                    customerOrder.setOrderTotal(rs.getDouble("order_total"));
                    customerOrder.setCustomerId(rs.getInt("customer_id"));
                    customerOrder.setOrderDate(rs.getDate("order_date"));
                    customerOrder.setPaymentTypeId(rs.getInt("payment_type_id"));
                    customerOrder.setProductId(rs.getInt("product_id"));
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
        return customerOrder;
    }

    @Override
    public CustomerOrder getCustomerOrderByProductID(int customerOrderId) {
        Connection connection = connectionPool.getConnection();
        CustomerOrder customerOrder = new CustomerOrder();
        String query = "SELECT * FROM customer_order WHERE customer_order_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, customerOrderId);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    customerOrder.setCustomerOrderId(rs.getInt("customer_order_id"));
                    customerOrder.setOrderTotal(rs.getDouble("order_total"));
                    customerOrder.setCustomerId(rs.getInt("customer_id"));
                    customerOrder.setOrderDate(rs.getDate("order_date"));
                    customerOrder.setPaymentTypeId(rs.getInt("payment_type_id"));
                    customerOrder.setProductId(rs.getInt("product_id"));
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
        return customerOrder;
    }
}
