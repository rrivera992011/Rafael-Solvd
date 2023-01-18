package com.solvd.pharmacyservice.sql.jdbc;

import com.solvd.pharmacyservice.models.EmployeeType;
import com.solvd.pharmacyservice.sql.*;
import org.apache.logging.log4j.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeTypeDAO implements IEmployeeTypeDAO {
    private static final Logger LOGGER = LogManager.getLogger("TEST_LOGGER");
    private ConnectionPool connectionPool = ConnectionPool.getInstance();

    @Override
    public void updateEntity(EmployeeType employeeType) {
        Connection connection = connectionPool.getConnection();
        String query = "UPDATE employee_type SET employee_type = (?) WHERE employee_type_id = (?) ";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, employeeType.getEmployeeType());
            ps.setInt(2, employeeType.getEmployeeTypeId());
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
    public EmployeeType createEntity(EmployeeType employeeType) {
        Connection connection = connectionPool.getConnection();
        String query = "INSERT INTO employee_type (employee_type_id, employee_type) VALUES((?), (?))";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, employeeType.getEmployeeTypeId());
            ps.setString(2, employeeType.getEmployeeType());
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
        return employeeType;
    }

    @Override
    public void removeEntity(int id) {
        Connection connection = connectionPool.getConnection();
        String query = "DELETE FROM employee_type WHERE employee_type_id = (?)";
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
    public List<EmployeeType> getAll() {
        Connection connection = connectionPool.getConnection();
        List<EmployeeType> resultList = new ArrayList<>();
        String query = "SELECT * FROM employee_type";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.execute();
            try(ResultSet rs = ps.getResultSet()) {
                while(rs.next()){
                    EmployeeType employeeType = new EmployeeType();
                    employeeType.setEmployeeTypeId(rs.getInt("employee_type_id"));
                    employeeType.setEmployeeType(rs.getString("employee_type"));
                    resultList.add(employeeType);
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
    public EmployeeType getEntityById(int id) {
        Connection connection = connectionPool.getConnection();
        EmployeeType employeeType = new EmployeeType();
        String query = "SELECT * FROM employee_type WHERE employee_type_id = (?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, id);
            ps.execute();
            try(ResultSet rs = ps.getResultSet()){
                while(rs.next()){
                    employeeType.setEmployeeTypeId(rs.getInt("employee_type_id"));
                    employeeType.setEmployeeType(rs.getString("employee_type"));
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
        return employeeType;
    }
}
